package com.example.java_clean_sample.presentation.controllers;

import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.product.DeleteProductException;
import com.example.java_clean_sample.data.ExceptionHandler.product.ProductNotFoundException;
import com.example.java_clean_sample.data.dtos.ProductDTO;
import com.example.java_clean_sample.data.services.CategoryService;
import com.example.java_clean_sample.data.services.ProductService;
import com.example.java_clean_sample.domain.entities.Product;
import com.example.java_clean_sample.presentation.requests.product.CreateProductRequest;
import com.example.java_clean_sample.presentation.requests.product.UpdateProductRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryService categoryService;


    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<Product> products = productService.findAll();
        List<ProductDTO> productDTOS = products.stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
        return ResponseEntity.ok(productDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findOne(@PathVariable int id) {
        Product product;
        try {
            product = productService.findOne(id);
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid CreateProductRequest rq, BindingResult rs) throws CategoryNotFoundException {
        if (rs.hasErrors()) {
            List<String> errors = rs.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        Product product = modelMapper.map(rq, Product.class);
        product.setCategory(categoryService.findOne(rq.getCategoryId()));

        Product saveProduct = null;
        try {
            saveProduct = productService.create(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ProductDTO productDTO = modelMapper.map(saveProduct, ProductDTO.class);

        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateProductRequest rq, BindingResult rs) throws CategoryNotFoundException {
        if (rs.hasErrors()) {
            List<String> errors = rs.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        Product product = modelMapper.map(rq, Product.class);
        product.setCategory(categoryService.findOne(rq.getCategoryId()));

        Product savedProduct= null;
        try {
            savedProduct = productService.update(id, product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ProductDTO productDTO = modelMapper.map(savedProduct, ProductDTO.class);

        return new ResponseEntity<>(productDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            productService.delete(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }  catch (DeleteProductException e) {
            throw new RuntimeException(e);
        }
    }
}

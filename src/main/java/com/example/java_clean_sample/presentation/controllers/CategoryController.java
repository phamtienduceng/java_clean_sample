package com.example.java_clean_sample.presentation.controllers;

import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.category.DeleteCategoryException;
import com.example.java_clean_sample.data.dtos.CategoryDTO;
import com.example.java_clean_sample.data.services.CategoryService;

import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.presentation.requests.category.CreateCategoryRequest;
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
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<Category> categories = categoryService.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).toList();
        return ResponseEntity.ok(categoryDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findOne(@PathVariable int id) {
        Category cate;
        try {
            cate = categoryService.findOne(id);
        } catch (CategoryNotFoundException e) {
            throw new RuntimeException(e);
        }
        CategoryDTO categoryDTO = modelMapper.map(cate, CategoryDTO.class);
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid CreateCategoryRequest rq, BindingResult rs){
        if (rs.hasErrors()) {
            List<String> errors = rs.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        Category category = modelMapper.map(rq, Category.class);

        Category savedCategory = null;
        try {
            savedCategory = categoryService.create(category);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        CategoryDTO categoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);

        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid CreateCategoryRequest rq, BindingResult rs){
        if (rs.hasErrors()) {
            List<String> errors = rs.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        Category category = modelMapper.map(rq, Category.class);

        Category savedCategory = null;
        try {
            savedCategory = categoryService.update(id, category);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        CategoryDTO categoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);

        return new ResponseEntity<>(categoryDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            categoryService.delete(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (DeleteCategoryException e) {
            throw new RuntimeException(e);
        }
    }

}

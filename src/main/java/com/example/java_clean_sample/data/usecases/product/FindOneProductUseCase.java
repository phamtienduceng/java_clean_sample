package com.example.java_clean_sample.data.usecases.product;

import com.example.java_clean_sample.data.ExceptionHandler.product.ProductNotFoundException;
import com.example.java_clean_sample.domain.entities.Product;
import com.example.java_clean_sample.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindOneProductUseCase {
    @Autowired
    ProductRepository productRepository;

    public Product execute(int id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).get();
        if (product == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found.");
        }
        return product;
    }
}

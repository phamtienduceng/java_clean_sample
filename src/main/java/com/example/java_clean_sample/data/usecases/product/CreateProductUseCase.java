package com.example.java_clean_sample.data.usecases.product;

import com.example.java_clean_sample.data.ExceptionHandler.product.CreateProductException;
import com.example.java_clean_sample.domain.entities.Product;
import com.example.java_clean_sample.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductUseCase {
    @Autowired
    ProductRepository productRepository;

    public Product execute(Product product) throws CreateProductException {
        try {
            return productRepository.save(product);
        } catch (Exception ex) {
            throw new CreateProductException("Error creating product: " + ex.getMessage(), ex);
        }
    }
}

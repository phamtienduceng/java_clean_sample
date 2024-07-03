package com.example.java_clean_sample.data.usecases.product;

import com.example.java_clean_sample.domain.entities.Product;
import com.example.java_clean_sample.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllProductUseCase {
    @Autowired
    ProductRepository productRepository;

    public List<Product> execute(){
        return productRepository.findAll();
    }
}

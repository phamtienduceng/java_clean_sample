package com.example.java_clean_sample.domain.repositories;

import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByCategory(Category category);
}

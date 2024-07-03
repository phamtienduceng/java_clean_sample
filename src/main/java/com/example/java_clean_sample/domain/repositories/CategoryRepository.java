package com.example.java_clean_sample.domain.repositories;

import com.example.java_clean_sample.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

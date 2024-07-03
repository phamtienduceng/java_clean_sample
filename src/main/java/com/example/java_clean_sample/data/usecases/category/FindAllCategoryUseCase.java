package com.example.java_clean_sample.data.usecases.category;

import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCategoryUseCase {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> execute(){
        return categoryRepository.findAll();
    }
}

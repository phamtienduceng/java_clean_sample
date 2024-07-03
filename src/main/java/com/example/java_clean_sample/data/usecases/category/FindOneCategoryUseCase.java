package com.example.java_clean_sample.data.usecases.category;

import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindOneCategoryUseCase {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category execute(int id) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(id).get();
        if (category == null) {
            throw new CategoryNotFoundException("Category with id " + id + " not found.");
        }
        return category;
    }
}


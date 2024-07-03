package com.example.java_clean_sample.data.usecases.category;


import com.example.java_clean_sample.data.ExceptionHandler.category.CreateCategoryException;
import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryUseCase {
    @Autowired
    CategoryRepository categoryRepository;

    public Category execute(Category category) throws CreateCategoryException {
        try {
            return categoryRepository.save(category);
        } catch (Exception ex) {
            throw new CreateCategoryException("Error creating category: " + ex.getMessage(), ex);
        }
    }
}

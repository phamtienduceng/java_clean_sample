package com.example.java_clean_sample.data.usecases.category;

import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.category.UpdateCategoryException;
import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryUseCase {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    FindOneCategoryUseCase findOneCategoryUseCase;

    public Category execute(int id, Category category) throws UpdateCategoryException {
        try {
            Category existingCategory = findOneCategoryUseCase.execute(id);
            if(existingCategory != null){
                existingCategory.setName(category.getName());
                return categoryRepository.save(existingCategory);
            } else {
                throw new CategoryNotFoundException("Category not found with id: " + id);
            }
        } catch (Exception ex) {
            throw new UpdateCategoryException("Error updating category: " + ex.getMessage(), ex);
        }
    }
}
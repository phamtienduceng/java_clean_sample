package com.example.java_clean_sample.data.usecases.category;


import com.example.java_clean_sample.data.ExceptionHandler.category.DeleteCategoryException;
import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryUseCase {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    FindOneCategoryUseCase findOneCategoryUseCase;

    public boolean execute(int id) throws DeleteCategoryException {
        try {
            Category category = findOneCategoryUseCase.execute(id);
            if (category != null) {
                categoryRepository.delete(category);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new DeleteCategoryException("Error deleting category: " + ex.getMessage(), ex);
        }
    }
}

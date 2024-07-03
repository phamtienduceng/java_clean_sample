package com.example.java_clean_sample.data.services;


import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.category.DeleteCategoryException;
import com.example.java_clean_sample.data.usecases.category.*;
import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.domain.serviceInterface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("data_category_service")
public class CategoryService implements ICategoryService {
    @Autowired
    FindOneCategoryUseCase findOneCategoryUseCase;

    @Autowired
    FindAllCategoryUseCase findAllCategoryUseCase;

    @Autowired
    CreateCategoryUseCase createCategoryUseCase;

    @Autowired
    UpdateCategoryUseCase updateCategoryUseCase;

    @Autowired
    DeleteCategoryUseCase deleteCategoryUseCase;

    @Override
    public Category findOne(int id) throws CategoryNotFoundException {
        return findOneCategoryUseCase.execute(id);
    }

    @Override
    public List<Category> findAll() {
        return findAllCategoryUseCase.execute();
    }

    @Override
    public Category create(Category category) throws Exception {
        return createCategoryUseCase.execute(category);
    }

    @Override
    public Category update(int id, Category category) throws Exception {
        return updateCategoryUseCase.execute(id, category);
    }

    @Override
    public boolean delete(int id) throws DeleteCategoryException {
        return deleteCategoryUseCase.execute(id);
    }
}

package com.example.java_clean_sample.domain.serviceInterface;

import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.category.DeleteCategoryException;
import com.example.java_clean_sample.data.ExceptionHandler.product.ProductNotFoundException;
import com.example.java_clean_sample.domain.entities.Category;

import java.util.List;

public interface ICategoryService {
    Category findOne(int id) throws CategoryNotFoundException, ProductNotFoundException, CategoryNotFoundException;

    List<Category> findAll();

    Category create(Category category) throws Exception;

    Category update(int id, Category category) throws Exception;

    boolean delete(int id) throws DeleteCategoryException, DeleteCategoryException;
}

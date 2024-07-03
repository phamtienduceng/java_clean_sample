package com.example.java_clean_sample.domain.serviceInterface;

import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.product.CreateProductException;
import com.example.java_clean_sample.data.ExceptionHandler.product.DeleteProductException;
import com.example.java_clean_sample.data.ExceptionHandler.product.ProductNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.product.UpdateProductException;
import com.example.java_clean_sample.domain.entities.Product;

import java.util.List;

public interface IProductService {
    Product findOne(int id) throws ProductNotFoundException, ProductNotFoundException;
    List<Product> findAll();

    List<Product> findByCategory(int id) throws CategoryNotFoundException, CategoryNotFoundException;

    Product create(Product product) throws CreateProductException, CreateProductException;
    Product update(int id, Product product) throws UpdateProductException, UpdateProductException;
    boolean delete(int id) throws DeleteProductException, DeleteProductException;
}

package com.example.java_clean_sample.data.services;

import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.product.CreateProductException;
import com.example.java_clean_sample.data.ExceptionHandler.product.DeleteProductException;
import com.example.java_clean_sample.data.ExceptionHandler.product.ProductNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.product.UpdateProductException;
import com.example.java_clean_sample.data.usecases.product.*;
import com.example.java_clean_sample.domain.entities.Product;
import com.example.java_clean_sample.domain.serviceInterface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("data_product_service")
public class ProductService implements IProductService {
    @Autowired
    FindOneProductUseCase findOneProductUseCase;

    @Autowired
    FindAllProductUseCase findAllProductUseCase;

    @Autowired
    FindProductByCategoryUseCase findProductByCategoryUseCase;

    @Autowired
    CreateProductUseCase createProductUseCase;

    @Autowired
    UpdateProductUseCase updateProductUseCase;

    @Autowired
    DeleteProductUseCase deleteProductUseCase;

    @Override
    public Product findOne(int id) throws ProductNotFoundException {
        return findOneProductUseCase.execute(id);
    }

    @Override
    public List<Product> findAll() {
        return findAllProductUseCase.execute();
    }

    @Override
    public List<Product> findByCategory(int id) throws CategoryNotFoundException {
        return findProductByCategoryUseCase.execute(id);
    }


    @Override
    public Product create(Product product) throws CreateProductException {
        return createProductUseCase.execute(product);
    }

    @Override
    public Product update(int id, Product product) throws UpdateProductException {
        return updateProductUseCase.execute(id, product);
    }

    @Override
    public boolean delete(int id) throws DeleteProductException {
        return deleteProductUseCase.execute(id);
    }
}

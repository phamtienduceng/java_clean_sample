package com.example.java_clean_sample.data.usecases.product;

import com.example.java_clean_sample.data.ExceptionHandler.category.CategoryNotFoundException;
import com.example.java_clean_sample.data.usecases.category.FindOneCategoryUseCase;
import com.example.java_clean_sample.domain.entities.Category;
import com.example.java_clean_sample.domain.entities.Product;
import com.example.java_clean_sample.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductByCategoryUseCase {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    FindOneCategoryUseCase findOneCategoryUseCase;

    public List<Product> execute(int id) throws CategoryNotFoundException {
        Category category = findOneCategoryUseCase.execute(id);
        return productRepository.findProductByCategory(category);
    }

}

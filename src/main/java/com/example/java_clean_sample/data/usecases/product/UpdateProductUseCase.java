package com.example.java_clean_sample.data.usecases.product;

import com.example.java_clean_sample.data.ExceptionHandler.product.ProductNotFoundException;
import com.example.java_clean_sample.data.ExceptionHandler.product.UpdateProductException;
import com.example.java_clean_sample.domain.entities.Product;
import com.example.java_clean_sample.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductUseCase {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    FindOneProductUseCase findOneProductUseCase;

    public Product execute(int id, Product product) throws UpdateProductException {
        try {
            Product existingProduct = findOneProductUseCase.execute(id);
            if(existingProduct != null){
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setStock(product.getStock());
                existingProduct.setCategory(product.getCategory());
                return productRepository.save(existingProduct);
            } else {
                throw new ProductNotFoundException("Product not found with id: " + id);
            }
        } catch (Exception ex) {
            throw new UpdateProductException("Error updating product: " + ex.getMessage(), ex);
        }
    }
}

package com.example.java_clean_sample.data.usecases.product;

import com.example.java_clean_sample.data.ExceptionHandler.product.DeleteProductException;
import com.example.java_clean_sample.domain.entities.Product;
import com.example.java_clean_sample.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductUseCase {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    FindOneProductUseCase findOneProductUseCase;

    public boolean execute(int id) throws DeleteProductException {
        try {
            Product product = findOneProductUseCase.execute(id);
            if (product != null) {
                productRepository.delete(product);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new DeleteProductException("Error deleting product: " + ex.getMessage(), ex);
        }
    }
}

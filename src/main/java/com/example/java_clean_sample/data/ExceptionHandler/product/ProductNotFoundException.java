package com.example.java_clean_sample.data.ExceptionHandler.product;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

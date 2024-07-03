package com.example.java_clean_sample.data.ExceptionHandler.product;

public class CreateProductException extends Exception {
    public CreateProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
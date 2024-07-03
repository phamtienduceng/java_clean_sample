package com.example.java_clean_sample.data.ExceptionHandler.product;

public class UpdateProductException extends Exception {
    public UpdateProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
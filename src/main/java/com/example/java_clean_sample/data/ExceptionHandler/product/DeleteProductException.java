package com.example.java_clean_sample.data.ExceptionHandler.product;

public class DeleteProductException extends Exception {
    public DeleteProductException(String message, Throwable cause) {
        super(message, cause);
    }
}

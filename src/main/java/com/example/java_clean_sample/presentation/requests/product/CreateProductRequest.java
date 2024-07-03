package com.example.java_clean_sample.presentation.requests.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private int categoryId;
}

package com.example.java_clean_sample.data.dtos;

import com.example.java_clean_sample.domain.entities.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private Long categoryId;
    private String name;
    private List<Product> products;
}

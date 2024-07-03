package com.example.java_clean_sample.data.dtos;

import com.example.java_clean_sample.domain.entities.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private Category category;
}

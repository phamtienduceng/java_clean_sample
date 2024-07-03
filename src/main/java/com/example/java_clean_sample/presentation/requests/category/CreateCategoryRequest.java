package com.example.java_clean_sample.presentation.requests.category;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateCategoryRequest {
    @NotEmpty
    @Length(min = 3, max = 50, message = "Length between 3 and 50 characters")
    private String name;
}

package com.example.shop.model.dto;

import java.util.List;

import com.example.shop.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private long categoryId;

    private String categoryName;

    private List<Product> products;
}

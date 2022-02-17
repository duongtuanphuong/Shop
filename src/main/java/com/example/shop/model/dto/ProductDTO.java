package com.example.shop.model.dto;

import com.example.shop.entity.Category;
import com.example.shop.entity.Sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long productId;
    
    private String productName;
    
    private float price;

    private int quantity;

    private String description;

    private String image;

    private Category Category;
    
    private Sale sale;
}

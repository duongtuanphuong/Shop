package com.example.shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long id;

    private String name;

    private float price;

    private int quantity;

    private String description;

    private String image;
}

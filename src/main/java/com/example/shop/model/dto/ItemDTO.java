package com.example.shop.model.dto;

import com.example.shop.entity.Order;
import com.example.shop.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    
    private long itemId;

    private ProductDTO productDTO;

    private float unitPrice;

    private int quantity;

    private Order oder;
}

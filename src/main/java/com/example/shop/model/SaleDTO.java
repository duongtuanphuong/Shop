package com.example.shop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    private long saleId;

    private int salePercent;

    private List<ProductDTO> productDTOs;
}

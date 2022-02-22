package com.example.shop.model.request;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductReq {
    
    private String name;

    private float price;

    private int quantity;

    private String description;

    @JsonProperty("category_Ids")
    private ArrayList<Integer> categoryIds;

    @JsonProperty("sale_id")
    private Integer saleId;
}

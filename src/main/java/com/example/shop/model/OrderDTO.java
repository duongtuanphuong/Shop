package com.example.shop.model;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    
    private long oderId;

    private UserDTO userDTO;

    private Date buyDate;

    private float priceTotal;

    private String status;

    private List<ItemDTO> ItemDTO;
}

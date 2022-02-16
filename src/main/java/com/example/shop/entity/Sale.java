package com.example.shop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="sale")
public class Sale {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private long saleId;

    @Column(name = "sale_percent")
    private String salePerent;

    @OneToMany(mappedBy = "sale")
    private List<Product> products;
}
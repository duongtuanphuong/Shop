package com.example.shop.repository;

import com.example.shop.entity.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
    
}

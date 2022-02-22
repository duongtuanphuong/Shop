package com.example.shop.service;

import java.util.List;

import com.example.shop.entity.Product;
import com.example.shop.model.request.CreateProductReq;

public interface ProductService {
    
    public List<Product> getListProduct();

    public Product createProduct(CreateProductReq req);

    public void updateProduct(CreateProductReq req, long id);

    public void deleteProduct(long id);
}

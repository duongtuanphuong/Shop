package com.example.shop.service;

import java.util.List;

import com.example.shop.entity.Category;
import com.example.shop.model.request.CreateCategoryReq;

public interface CategoryService {
    
    public List<Category> getListCategory();

    public Category createCategory(CreateCategoryReq req);

    public void updateCategory(CreateCategoryReq req, long id);

    public void deleteCategory(long id);

}

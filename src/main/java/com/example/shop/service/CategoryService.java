package com.example.shop.service;

import java.util.List;

import com.example.shop.entity.Category;
import com.example.shop.model.dto.CategoryDTO;

public interface CategoryService {
    
    public List<Category> findAll();
    public Category createCategory(CategoryDTO req);
    public void updateCategory(long id, CategoryDTO req);
    public void deleteCategory(long id);
}

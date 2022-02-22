package com.example.shop.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.shop.entity.Category;
import com.example.shop.exception.InternalServerException;
import com.example.shop.exception.NotFoundException;
import com.example.shop.model.request.CreateCategoryReq;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getListCategory() {
        // TODO Auto-generated method stub
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(CreateCategoryReq req) {
        // TODO Auto-generated method stub
        Category category = new Category();
        category.setName(req.getName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void updateCategory(CreateCategoryReq req, long id) {
        // TODO Auto-generated method stub
        Optional<Category> rs = categoryRepository.findById(id);
        if(rs.isEmpty()){
            throw new NotFoundException("Danh mục không tồn tại");
        }

        Category category = rs.get();

        category.setName(req.getName());

        try{
            categoryRepository.save(category);
        } catch (Exception e){
            throw new InternalServerException("Cập nhật danh mục bị lỗi");
        }
        
    }

    @Override
    public void deleteCategory(long id) {
        // TODO Auto-generated method stub
        
    }
    
}

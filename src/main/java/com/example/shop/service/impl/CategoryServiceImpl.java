package com.example.shop.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.shop.entity.Category;
import com.example.shop.exception.BadRequestException;
import com.example.shop.exception.InternalServerException;
import com.example.shop.exception.NotFoundException;
import com.example.shop.model.dto.CategoryDTO;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {

        // TODO Auto-generated method stub
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(CategoryDTO req) {
        // TODO Auto-generated method stub
        Category category = new Category();
        category.setCategoryName(req.getCategoryName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void updateCategory(long id, CategoryDTO req) {
        // TODO Auto-generated method stub
        Optional<Category> rs = categoryRepository.findById(id);
        if(rs.isEmpty()){
            throw new NotFoundException("Không tìm thấy danh mục");
        }
        Category category = rs.get();
        category.setCategoryName(req.getCategoryName());
        try{
            categoryRepository.save(category);
        } catch (Exception e){
            throw new InternalServerException("Lỗi cập nhật danh mục");
        }
        
    }

    @Override
    public void deleteCategory(long id) {
        // TODO Auto-generated method stub
        Optional<Category> rs = categoryRepository.findById(id);
        if(rs.isEmpty()){
            throw new NotFoundException("Không tìm thấy danh mục");
        }

        // long count = categoryRepository.checkProductInCategory(id);
        // if(count == 1){
        //     throw new BadRequestException("Danh mục còn sản phẩm không thể xóa");
        // }

        Category category = rs.get();

        try{
            categoryRepository.delete(category);
        }catch (Exception e){
            throw new InternalServerException("Lỗi thể xóa danh mục");
        }

    }
    

}

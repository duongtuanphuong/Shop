package com.example.shop.controller.admin;

import java.util.List;

import com.example.shop.entity.Category;
import com.example.shop.model.dto.CategoryDTO;
import com.example.shop.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/categories")
    public String getCategory(Model model){
        List<Category> categories = categoryService.findAll(); 
        model.addAttribute("categories", categories);
        return "admin/category/list";
    }

    @PostMapping("/api/admin/categories")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO req){
        Category category = categoryService.createCategory(req);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/api/admin/categories/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO req, @PathVariable long id){
        categoryService.updateCategory(id, req);
        return ResponseEntity.ok("cập nhật thành công");
    }
    
    @DeleteMapping("/api/admin/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}

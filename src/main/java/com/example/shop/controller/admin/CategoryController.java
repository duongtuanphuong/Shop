package com.example.shop.controller.admin;

import java.util.List;

import com.example.shop.entity.Category;
import com.example.shop.model.request.CreateCategoryReq;
import com.example.shop.service.CategoryService;
import com.example.shop.service.ProductService;

import org.apache.catalina.connector.Response;
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

    @GetMapping("/admin/category")
    public String getListCategory(Model model){
        List<Category> categories = categoryService.getListCategory();
        model.addAttribute("categories", categories);
        return "admin/category/list";
    }


    @PostMapping("/api/admin/category")
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryReq req){
        Category category = categoryService.createCategory(req);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/api/admin/category/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody CreateCategoryReq req,@PathVariable long id){
        categoryService.updateCategory(req, id);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/api/admin/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Xoá thành công");
    }

}

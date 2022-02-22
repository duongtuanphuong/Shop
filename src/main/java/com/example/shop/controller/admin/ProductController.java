package com.example.shop.controller.admin;

import java.util.List;

import com.example.shop.entity.Category;
import com.example.shop.entity.Product;
import com.example.shop.entity.Sale;
import com.example.shop.model.request.CreateProductReq;
import com.example.shop.service.CategoryService;
import com.example.shop.service.ProductService;
import com.example.shop.service.SaleService;

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
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SaleService saleService;

    @GetMapping("/admin/product")
    public String getListProduct(Model model){
        List<Product> products = productService.getListProduct();
        List<Category> categories = categoryService.getListCategory();
        List<Sale> sales = saleService.getListSale();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("sales", sales);
        return "/admin/product/list";
    }

    @PostMapping("/api/admin/product")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductReq req){
        Product product = productService.createProduct(req);

        return ResponseEntity.ok(product);
    }

    @PutMapping("/api/admin/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody CreateProductReq req, @PathVariable long id){
        productService.updateProduct(req, id);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/api/admin/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}

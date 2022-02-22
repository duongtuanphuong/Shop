package com.example.shop.controller.admin;

import java.util.List;

import com.example.shop.entity.Sale;
import com.example.shop.model.request.CreateCategoryReq;
import com.example.shop.model.request.CreateSaleReq;
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
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("/admin/sale")
    public String getListSale(Model model){
        List<Sale> sales = saleService.getListSale();

        model.addAttribute("sales", sales);

        return "/admin/sale/list";
    
    }

    @PostMapping("/api/admin/sale")
    public ResponseEntity<Sale> createSale(@RequestBody CreateSaleReq req){
        Sale sale  = saleService.createSale(req);
        return ResponseEntity.ok(sale);
    }

    @PutMapping("/api/admin/sale/{id}")
    public ResponseEntity<?> updateSale(@RequestBody CreateSaleReq req,@PathVariable long id){
        saleService.updateSale(req, id);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/api/admin/sale/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable long id ){
        saleService.deleteSale(id);
        return ResponseEntity.ok("Xóa thành công");
    }

}

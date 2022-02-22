package com.example.shop.service;

import java.util.List;

import com.example.shop.entity.Sale;
import com.example.shop.model.request.CreateSaleReq;

public interface SaleService {
    
    public List<Sale> getListSale();

    public Sale createSale(CreateSaleReq req);

    public void updateSale(CreateSaleReq req, long id);

    public void deleteSale(long id);

}

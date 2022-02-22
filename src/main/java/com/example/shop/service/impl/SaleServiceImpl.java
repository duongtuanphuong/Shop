package com.example.shop.service.impl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import com.example.shop.entity.Sale;
import com.example.shop.exception.InternalServerException;
import com.example.shop.exception.NotFoundException;
import com.example.shop.model.request.CreateSaleReq;
import com.example.shop.repository.SaleRepository;
import com.example.shop.service.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> getListSale() {
        // TODO Auto-generated method stub
        return saleRepository.findAll();
    }

    @Override
    public Sale createSale(CreateSaleReq req) {
        // TODO Auto-generated method stub
        Sale sale = new Sale();
        sale.setSalePercent(req.getSalePercent());
        return saleRepository.save(sale);
    }

    @Override
    public void updateSale(CreateSaleReq req, long id) {
        // TODO Auto-generated method stub
        Optional<Sale> rs = saleRepository.findById(id);

        if(rs.isEmpty()){
            throw new NotFoundException("Không tìm thấy khuyến mãi");
        }

        Sale sale = new Sale();

        sale.setSalePercent(req.getSalePercent());
        
        try{
            saleRepository.save(sale);
        } catch (Exception e){
            throw new InternalServerException("Lỗi khi sửa khuyến mãi");
        }
    }

    @Override
    public void deleteSale(long id) {
        // TODO Auto-generated method stub
        
    }
    
}

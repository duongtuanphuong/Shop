package com.example.shop.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.shop.entity.Product;
import com.example.shop.exception.BadRequestException;
import com.example.shop.exception.InternalServerException;
import com.example.shop.exception.NotFoundException;
import com.example.shop.model.mapper.ProductMapper;
import com.example.shop.model.request.CreateProductReq;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getListProduct() {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(CreateProductReq req) {
        // TODO Auto-generated method stub
        if(req.getCategoryIds().size() == 0){
            throw new BadRequestException("Danh mục rỗng");
        }

        Product product = ProductMapper.toProduct(req);

        try{
            productRepository.save(product);
        } catch(Exception e){
            throw new InternalServerException("Lỗi khi tạo sản phẩm");
        }

        return product;
    }

    @Override
    public void updateProduct(CreateProductReq req, long id) {
        // TODO Auto-generated method stub
        Optional<Product> rs = productRepository.findById(id);
        
        if(rs.isEmpty()){
            throw new NotFoundException("Không tìm  thấy sản phẩm");
        }

        if(req.getCategoryIds().size()==0){
            throw new BadRequestException("Danh mục rỗng");
        }
        Product product = ProductMapper.toProduct(req);
        product.setId(id);
    

        try{
            productRepository.save(product);
        }catch(Exception e){
            throw new InternalServerException("Lỗi khi sửa sản phẩm");
        }
    }

    @Override
    public void deleteProduct(long id) {
        // TODO Auto-generated method stub
        
    }
    
}

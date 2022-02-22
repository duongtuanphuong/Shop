package com.example.shop.model.mapper;

import java.util.ArrayList;

import com.example.shop.entity.Category;
import com.example.shop.entity.Product;
import com.example.shop.entity.Sale;
import com.example.shop.model.dto.ProductDTO;
import com.example.shop.model.request.CreateProductReq;

public class ProductMapper {
    

    public static ProductDTO toProductDTO(Product product){
        ProductDTO rs = new ProductDTO();
        rs.setId(product.getId());
        rs.setName(product.getName());
        rs.setPrice(product.getPrice());
        rs.setQuantity(product.getQuantity());
        rs.setImage(product.getImage());

        return rs;
    }

    public static Product toProduct(CreateProductReq req){
        Product product = new Product();

        product.setName(req.getName());

        product.setPrice(req.getPrice());

        product.setQuantity(req.getQuantity());

        product.setDescription(req.getDescription());

        // Set sale
        Sale sale = new Sale();
        sale.setId(req.getSaleId());

        product.setSale(sale);

        // Set category

        ArrayList<Category> categories = new ArrayList<Category>();        
        for(Integer id : req.getCategoryIds()){
            Category category = new Category();
            category.setId(id);
            categories.add(category);
        }
        product.setCategories(categories);

        return product;

    }

}

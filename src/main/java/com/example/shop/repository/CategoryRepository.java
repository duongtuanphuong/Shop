package com.example.shop.repository;

import com.example.shop.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(nativeQuery = true, value = "Select 1 from product_category where category_id = ?1")
    public long checkProductInCategory(long id);
}

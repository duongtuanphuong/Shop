package com.example.shop.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name= "quantity")
    private int quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(name = "product_category",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
        )
        private List<Category> categories;

    @ManyToOne
    @JoinColumn (name = "sale_id")
    private Sale sale;
    

    // public void addCategory(Category category){
    //     this.categories.add(category);
    //     category.getProducts().add(this);
    // }

    // public void removeCategory(Category category){
    //     this.getCategories().remove(category);
    //     category.getProducts().remove(this);
    // }

    // public void removeCategories(){
    //     for(Category category : new HashSet<>(categories)){
    //         removeCategory(category);
    //     }
    // }
}

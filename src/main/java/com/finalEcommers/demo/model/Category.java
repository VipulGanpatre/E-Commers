package com.finalEcommers.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String title;
    @OneToMany(mappedBy="category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Product> product;

    public Set<Product> getProduct(Set<Product> product) {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }



    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category(int categoryId, String title) {
        super();
        this.categoryId = categoryId;
        this.title = title;
    }
    public Category(){
        super();
    }
}

package com.finalEcommers.demo.common;

import jakarta.annotation.Nonnull;

public class ProductDto {
    private Integer id;
    private @Nonnull String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private @Nonnull String description;



    private @Nonnull String imageUrl;
   public ProductDto(){
       super();
   }
    public ProductDto(Integer id, String categoryName, String description, String imageUrl) {
        super();
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}

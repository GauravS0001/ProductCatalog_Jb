package com.gaurav.productcatalog.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String name;
    private String category;
    private Double price;
    private Boolean featured;
    private String imageUrl;

    private LocalDateTime lastUpdated = LocalDateTime.now();  

    public Product() {}

    public Product(Long id, String name, String category, Double price, Boolean featured, String imageUrl, LocalDateTime lastUpdated) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.featured = featured;
        this.imageUrl = imageUrl;
        this.lastUpdated = lastUpdated != null ? lastUpdated : LocalDateTime.now();  
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

package com.fsad.productmanagement.dto;

import java.math.BigDecimal;

public class ProductResponse {
    private Long id;
    private String productName;
    private String category;
    private BigDecimal price;
    private Integer quantity;
    private String brand;
    private String description;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String productName, String category, BigDecimal price, Integer quantity, String brand, String description) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


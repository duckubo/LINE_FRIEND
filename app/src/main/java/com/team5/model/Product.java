package com.team5.model;

public class Product {

    private  String productName;

    public Product(int butbihinhtraitim, String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

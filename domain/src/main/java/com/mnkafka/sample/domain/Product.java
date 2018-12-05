package com.mnkafka.sample.domain;

public class Product {
    private String name;
    private Integer quantity;
    private String sku;
    private String brand;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public Product setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Product setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", sku='" + sku + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}

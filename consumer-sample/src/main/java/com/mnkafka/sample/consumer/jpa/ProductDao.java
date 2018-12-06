package com.mnkafka.sample.consumer.jpa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class ProductDao {

    public ProductDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false, unique = false)
    private String name;
    @NotNull
    @Column(name = "brand", nullable = false, unique = false)
    private String brand;
    @NotNull
    @Column(name = "sku", nullable = false, unique = false)
    private String sku;
    @NotNull
    @Column(name = "quantity", nullable = false, unique = false)
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public ProductDao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDao setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ProductDao setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public ProductDao setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductDao setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

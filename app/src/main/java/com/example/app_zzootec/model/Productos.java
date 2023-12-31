package com.example.app_zzootec.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Productos {

    private Long id;
    private String name;
    private String image;
    private String price;
    private String stock;
    private Proveedores supplier;
    private Categoria category;
    private Object storage;

    public Productos() {
    }

    public Productos(Long id, String name, String image, String price, String stock, Proveedores supplier, Categoria category, Object storage) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.supplier = supplier;
        this.category = category;
        this.storage = storage;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Proveedores getSupplier() {
        return supplier;
    }

    public void setSupplier(Proveedores supplier) {
        this.supplier = supplier;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public Object getStorage() {
        return storage;
    }

    public void setStorage(Object storage) {
        this.storage = storage;
    }
}


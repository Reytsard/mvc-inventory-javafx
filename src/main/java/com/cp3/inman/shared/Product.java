package com.cp3.inman.shared;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private float price;

    public Product(){
        this.id = -1;
        this.name = "";
        this.quantity = -1;
        this.price = -1.0f;
    }
    public Product(int id, String name, int quantity, float price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

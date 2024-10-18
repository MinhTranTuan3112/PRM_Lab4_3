package com.example.demopassingdata;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    public int id;
    public String name;
    public double price;

    public Product() {

    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

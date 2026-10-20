package com.shop.services;

import com.shop.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return new ArrayList<>(products);
    }
}

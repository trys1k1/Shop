package com.shop.services;

import com.shop.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> items = new ArrayList<>();
    public void addProduct(Product product){
        items.add(product);
    }
    public void removeProduct(Product product){
        items.remove(product);
    }
    public double getTotalPrice(){
        return items.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
    public List<Product> getItems(){
        return new ArrayList<>(items);

    }
    public void clear(){
        items.clear();
    }

}

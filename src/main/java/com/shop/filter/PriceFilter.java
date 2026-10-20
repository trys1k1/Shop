package com.shop.filter;

import com.shop.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class PriceFilter implements ProductFilter{
    private final double maxPrice;

    public PriceFilter(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return products.stream()
                .filter(p -> p.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}

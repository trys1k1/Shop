package com.shop.filter;

import com.shop.models.Product;

import java.util.List;

public interface ProductFilter {
    List<Product> filter(List<Product> products);
}

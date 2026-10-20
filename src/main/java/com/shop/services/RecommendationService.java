package com.shop.services;

import com.shop.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class RecommendationService {
    public List<Product> getRecommendations(List<Product> allProducts,
                                            List<Product> userHistory){
        return allProducts.stream()
                .filter(p -> !userHistory.contains(p))
                .limit(3)
                .collect(Collectors.toList());
    }
}

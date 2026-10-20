package com.shop;

import com.shop.filter.PriceFilter;
import com.shop.filter.ProductFilter;
import com.shop.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceFilterTest {
    private List<Product> products;

    @BeforeEach
    void setUp() {
        products = List.of(
                new Product("1", "Ноутбук", 1000, "Lenovo"),
                new Product("2", "Мышь", 50, "Logitech"),
                new Product("3", "Монитор", 300, "Samsung")
        );
    }

    @Test
    void filter_ShouldReturnProductsBelowThreshold() {
        ProductFilter filter = new PriceFilter(500);
        List<Product> result = filter.filter(products);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(p -> p.getPrice() <= 500));
    }

    @Test
    void filter_WhenThresholdIsHigh_ShouldReturnAll() {
        ProductFilter filter = new PriceFilter(2000);
        List<Product> result = filter.filter(products);

        assertEquals(3, result.size());
    }

    @Test
    void filter_WhenThresholdIsLow_ShouldReturnEmptyList() {
        ProductFilter filter = new PriceFilter(10);
        List<Product> result = filter.filter(products);

        assertTrue(result.isEmpty());
    }
}
package com.shop;

import com.shop.models.Product;
import com.shop.services.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        product1 = new Product("1", "Ноутбук", 1000, "Lenovo");
        product2 = new Product("2", "Мышь", 50, "Logitech");
    }

    @Test
    void addProduct_ShouldIncreaseCartSize() {
        cart.addProduct(product1);
        assertEquals(1, cart.getItems().size());
        assertTrue(cart.getItems().contains(product1));
    }

    @Test
    void removeProduct_ShouldDecreaseCartSize() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);

        assertEquals(1, cart.getItems().size());
        assertFalse(cart.getItems().contains(product1));
        assertTrue(cart.getItems().contains(product2));
    }

    @Test
    void getTotalPrice_ShouldReturnCorrectSum() {
        cart.addProduct(product1); // 1000
        cart.addProduct(product2); // 50

        assertEquals(1050.0, cart.getTotalPrice());
    }

    @Test
    void getTotalPrice_OnEmptyCart_ShouldReturnZero() {
        assertEquals(0.0, cart.getTotalPrice());
    }
}
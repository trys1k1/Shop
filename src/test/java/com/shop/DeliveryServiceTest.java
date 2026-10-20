package com.shop;

import com.shop.models.Order;
import com.shop.models.OrderStatus;
import com.shop.models.Product;
import com.shop.models.User;
import com.shop.services.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {
    private DeliveryService deliveryService;
    private Order order;

    @BeforeEach
    void setUp() {
        deliveryService = new DeliveryService();
        User user = new User("Иван");
        List<Product> products = List.of(new Product("1", "Ноутбук", 1000, "Lenovo"));
        order = new Order(user, products);
    }

    @Test
    void newOrder_ShouldHaveCreatedStatus() {
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    void returnOrder_ShouldChangeStatusToReturned() {
        // Имитируем отправку
        order.setStatus(OrderStatus.SHIPPED);

        // Возвращаем
        deliveryService.returnOrder(order);

        assertEquals(OrderStatus.RETURNED, order.getStatus());
    }
}
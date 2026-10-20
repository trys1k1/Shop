package com.shop.models;

import java.util.List;

public class Order {
    private final User user;
    private List<Product> products;
    private OrderStatus status;

    public Order(User user, List<Product> products) {
        this.user = user;
        this.products = products;
        this.status = OrderStatus.CREATED;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

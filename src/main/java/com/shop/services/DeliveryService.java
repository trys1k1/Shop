package com.shop.services;

import com.shop.models.Order;
import com.shop.models.OrderStatus;

public class DeliveryService {
    public void trackOrder(Order order){
        System.out.println("Статус заказа: " + order.getStatus());

    }
    public void returnOrder(Order order){
        order.setStatus(OrderStatus.RETURNED);
        System.out.println("Заказ возвращен");
    }
}

package com.shop;

import com.shop.filter.PriceFilter;
import com.shop.filter.ProductFilter;
import com.shop.models.Order;
import com.shop.models.OrderStatus;
import com.shop.models.Product;
import com.shop.models.User;
import com.shop.services.Catalog;
import com.shop.services.*;

import java.util.List;

public class Main {
    public static final double MAX_PRICE = 500;

    public static void main(String[] args) {


        Catalog catalog = new Catalog();
        catalog.addProduct(new Product("1", "Ноутбук", 1000, "Lenovo"));
        catalog.addProduct(new Product("2", "Мышь", 50, "Logitech"));
        catalog.addProduct(new Product("3", "Монитор", 300, "Samsung"));

        User user = new User("Иван");

        ProductFilter cheapFilter = new PriceFilter(MAX_PRICE);
        List<Product> cheapProducts = cheapFilter.filter(catalog.getAllProducts());
        System.out.println("Дешевые товары: " + cheapProducts.size());

        Cart cart = new Cart();
        cart.addProduct(catalog.getAllProducts().get(1)); // Добавили мышь
        cart.addProduct(catalog.getAllProducts().get(2)); // Добавили монитор

        Order order = new Order(user, cart.getItems());

        DeliveryService delivery = new DeliveryService();
        delivery.trackOrder(order); // Статус: Created

        // Имитация отправки
        order.setStatus(OrderStatus.SHIPPED);
        delivery.trackOrder(order);

        RecommendationService recService = new RecommendationService();
        List<Product> recommendations = recService.getRecommendations(
                catalog.getAllProducts(),
                cart.getItems()
        );
        if (!recommendations.isEmpty()) {
            System.out.println("Рекомендуем также посмотреть: " + recommendations.get(0).getName());
        } else {
            System.out.println("Рекомендаций пока нет");
        }
    }
}
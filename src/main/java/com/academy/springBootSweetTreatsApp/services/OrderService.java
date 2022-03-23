package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Order;

import java.util.List;

public interface OrderService {
    void createOrder();

    void editOrder();

    void deleteOrder();

    List<Order> getOrders();
}

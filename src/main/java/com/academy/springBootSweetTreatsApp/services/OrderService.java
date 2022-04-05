package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {


    void createOrder(Order order);

    List<Order> getOrders();

    Optional<Order> getOneOrder(String id);

    void editOrder();

    void deleteOrder(String id);
}

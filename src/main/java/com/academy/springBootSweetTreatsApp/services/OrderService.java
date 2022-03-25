package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.models.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {


    void createOrder(Order order);

    List<Order> getOrders();

    Order getOneOrder(UUID id);

    void editOrder();

    void deleteOrder();
}

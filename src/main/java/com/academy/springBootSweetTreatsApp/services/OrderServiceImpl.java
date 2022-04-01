package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.exceptions.OrderNotFound;
import com.academy.springBootSweetTreatsApp.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    List<Order> orderList;

    @Override
    public void createOrder(Order order) {
        orderList.add(order);
    }

    @Override
    public List<Order> getOrders() {
        if(orderList.isEmpty())
            throw new OrderNotFound("order not found");
        return orderList;
    }

    @Override
    public Order getOneOrder(UUID id) {
        Order order = null;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId().equals(id))
                order = orderList.get(i);

        }
        if(order==null)
            throw new  OrderNotFound("order not found");
        return order;
    }

    @Override
    public void editOrder() {

    }

    @Override
    public void deleteOrder() {

    }


}

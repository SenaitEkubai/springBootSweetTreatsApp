package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.exceptions.OrderNotFound;
import com.academy.springBootSweetTreatsApp.models.Order;

import com.academy.springBootSweetTreatsApp.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.insert(order);
    }

    @Override
    public List<Order> getOrders() {

        if(orderRepository.count()==0)
            throw new OrderNotFound("order not found");

        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOneOrder(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public void editOrder() {

    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }


}

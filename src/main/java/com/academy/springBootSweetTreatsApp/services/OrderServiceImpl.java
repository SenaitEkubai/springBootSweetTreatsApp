package com.academy.springBootSweetTreatsApp.services;
import com.academy.springBootSweetTreatsApp.models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{
    List<Order> orderList= new ArrayList<>() ;
    @Override
    public void createOrder(Order order) {
       orderList.add(order);
    }

    @Override
    public void editOrder() {

    }

    @Override
    public void deleteOrder() {

    }

    @Override
    public List<Order> getOrders() {
        return orderList;
    }

    @Override
    public Order getOneOrder(UUID id) {
        Order order=null;
        for (int i = 0; i < orderList.size(); i++) {
            if(orderList.get(i).getId().equals(id))
                order=orderList.get(i);

        }
        return order;
    }

}

package com.academy.springBootSweetTreatsApp.controllers;

import com.academy.springBootSweetTreatsApp.models.Order;
import com.academy.springBootSweetTreatsApp.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("sweettreats/orders")
public class OrderController {

    OrderService orderService;

    // get order

    @RequestMapping(path = "/")
    List<Order> getOrders() {
        return orderService.getOrders();
    }

    // get one order by id

    @RequestMapping(path = "/{id}")
    Order getOneOrder(@PathVariable("id") UUID id) {
        return orderService.getOneOrder(id);
    }

    // add order

    @PostMapping(path = "/addorder")
    ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity<>("order created successfully", HttpStatus.OK);
    }
}

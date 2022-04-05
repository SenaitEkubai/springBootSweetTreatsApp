package com.academy.springBootSweetTreatsApp.controllers;

import com.academy.springBootSweetTreatsApp.models.Order;
import com.academy.springBootSweetTreatsApp.services.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("sweettreats/orders")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping(path = "/")
    List<Order> getAllOrders() {
        return orderService.getOrders();
    }

    @RequestMapping(path = "/{id}")
    Optional<Order> getOneOrderById(@PathVariable("id") String id) {
        return orderService.getOneOrder(id);
    }

    @PostMapping(path = "/addorder")
    ResponseEntity<String> createOneOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity<>("order created successfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteOrder/{id}")
    ResponseEntity<String> deleteOneOrderById(@PathVariable("id") String id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>("order deleted successfully", HttpStatus.OK);
    }
}

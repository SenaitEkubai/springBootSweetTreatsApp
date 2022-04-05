package com.academy.springBootSweetTreatsApp.repository;

import com.academy.springBootSweetTreatsApp.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}

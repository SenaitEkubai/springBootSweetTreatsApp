package com.academy.springBootSweetTreatsApp.repository;

import com.academy.springBootSweetTreatsApp.models.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourierRepository extends MongoRepository<Courier, String> {
}

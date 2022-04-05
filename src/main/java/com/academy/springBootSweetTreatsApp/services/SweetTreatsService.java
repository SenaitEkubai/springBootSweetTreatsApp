package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.models.Order;

import java.util.List;
import java.util.UUID;

public interface SweetTreatsService {
    List<Courier> suitableCouriers(Order order);

    Courier cheapestCourier(Order order);
}

package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Courier;

import java.util.List;
import java.util.UUID;

public interface SweetTreatsService {
    List<Courier> suitableCouriers(UUID id);

    Courier cheapestCourier(UUID id);
}

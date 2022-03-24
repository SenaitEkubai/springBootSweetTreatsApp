package com.academy.springBootSweetTreatsApp.controllers;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.services.SweetTreatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class SweetTreatsController {
    @Autowired
    SweetTreatsService sweetTreatsService;

    // get suitable couriers for an order
    @RequestMapping(path = "/suitableCouriers/{id}")
    List<Courier> getSuitableCouriers(@PathVariable("id") UUID id) {
        return sweetTreatsService.suitableCouriers(id);

    }
    // get the cheapest courier for an order
    @RequestMapping(path = "/cheapest/{id}")
    Courier getCheapestCourier(@PathVariable("id") UUID id) {
        return sweetTreatsService.cheapestCourier(id);

    }

}

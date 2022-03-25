package com.academy.springBootSweetTreatsApp.controllers;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.services.SweetTreatsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("sweettreats")
public class SweetTreatsController {

    SweetTreatsService sweetTreatsService;

    // get suitable couriers for an order by passing an order id

    @RequestMapping(path = "/suitablecouriers/{id}")
    List<Courier> getSuitableCouriers(@PathVariable("id") UUID id) {
        return sweetTreatsService.suitableCouriers(id);

    }

    // get the cheapest courier for an order by passing order id

    @RequestMapping(path = "/cheapestcourier/{id}")
    Courier getCheapestCourier(@PathVariable("id") UUID id) {
        return sweetTreatsService.cheapestCourier(id);

    }

}

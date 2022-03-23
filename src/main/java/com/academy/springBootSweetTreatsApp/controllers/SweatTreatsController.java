package com.academy.springBootSweetTreatsApp.controllers;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SweatTreatsController {
    @Autowired
    CourierService courierService;

    // get all couriers endpoint
    @RequestMapping(path = "/couriers")
    List<Courier> getAllCouriers() {
        return courierService.getCouriers();
    }

    //  create one courier endpoint
    @PostMapping(path = "/addCourier")
    void addOneCourier(@RequestBody Courier courier) {
        courierService.createACourier(courier);

    }
    // create many couriers at ones
    @PostMapping(path = "/addManyCourier")
    void addManyCouriers(@RequestBody List<Courier> couriers) {
        courierService.createManyCouriers(couriers);

    }
    // next to do
    /*create delete, update for courier service && delete, create, update for order service && cheapest and suitable couriers for sweatTreats class  */

}

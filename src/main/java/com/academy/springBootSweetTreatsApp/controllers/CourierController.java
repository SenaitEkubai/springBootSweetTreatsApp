package com.academy.springBootSweetTreatsApp.controllers;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.models.Order;
import com.academy.springBootSweetTreatsApp.services.CourierServiceImpl;
import com.academy.springBootSweetTreatsApp.services.SweetTreatsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("sweettreats")
public class CourierController {

    @Autowired
    CourierServiceImpl courierService;

    @Autowired
    SweetTreatsServiceImpl sweetTreatsService;

    @RequestMapping(path = "/couriers")
    List<Courier> getAllCouriers() {
        return courierService.getCouriers();
    }

    @PostMapping(path = "couriers/addcourier")
    ResponseEntity<String> addOneCourier(@RequestBody Courier courier) {
        courierService.createACourier(courier);
        return new ResponseEntity<>("Courier is added successfully", HttpStatus.OK);
    }

    @PostMapping(path = "couriers/addcouriers")
    ResponseEntity<?> addManyCouriers(@RequestBody List<Courier> couriers) {
        courierService.createManyCouriers(couriers);
        return new ResponseEntity<>("Couriers added successfully", HttpStatus.OK);
    }

    @RequestMapping(path = "couriers/{id}")
    Optional<Courier> getOneCourierById(@PathVariable("id") String id) {
        return courierService.getCourierById(id);
    }

    @DeleteMapping(path = "couriers/{id}")
    void deleteOneCourierById(@PathVariable("id") String id) {
        courierService.deleteCourier(id);
    }


    @RequestMapping(path = "/suitablecouriers")
    List<Courier> getSuitableCouriers(@RequestBody Order order) {
        return sweetTreatsService.suitableCouriers(order);
    }

    @RequestMapping(path = "/cheapestcourier")
    Courier getCheapestCourier(@RequestBody Order order) {
        return sweetTreatsService.cheapestCourier(order);

    }
}

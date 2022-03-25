package com.academy.springBootSweetTreatsApp.controllers;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.services.CourierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("sweettreats/couriers")
public class CourierController {
    @Autowired
    CourierService courierService;
    // get all couriers endpoint

    @RequestMapping(path = "/")
    List<Courier> getAllCouriers() {
        return courierService.getCouriers();
    }


    //  create one courier endpoint

    @PostMapping(path = "/addcourier")
    ResponseEntity<String> addOneCourier(@RequestBody Courier courier) {
        courierService.createACourier(courier);
        return new ResponseEntity<>("Courier is added successfully", HttpStatus.OK);
    }

    // create many couriers at once

    @PostMapping(path = "/addcouriers")
    ResponseEntity<String> addManyCouriers(@RequestBody List<Courier> couriers) {
        courierService.createManyCouriers(couriers);
        return new ResponseEntity<>("Couriers are added successfully", HttpStatus.OK);
    }


    // get one courier by id

    @RequestMapping(path = "/{id}")
    Courier getOneCourier(@PathVariable("id") UUID id) {
        return courierService.getOneCourier(id);
    }

}

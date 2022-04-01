package com.academy.springBootSweetTreatsApp.controllers;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.services.CourierService;
import com.academy.springBootSweetTreatsApp.services.CourierServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("sweettreats")
public class CourierController {
    @Autowired
    CourierServiceImpl courierService;


    // all couriers

    @RequestMapping(path = "/couriers")
    List<Courier> getAllCouriers() {
        return courierService.getCouriers();
    }


   /* //  create one courier

    @PostMapping(path = "couriers/addcourier")
    ResponseEntity<String> addOneCourier(@RequestBody Courier courier) {
        courierService.createACourier(courier);
        return new ResponseEntity<>("Courier is added successfully", HttpStatus.OK);
    }*/
    //  create one courier

    @PostMapping(path = "couriers/addcourier")
    ResponseEntity<String> addOneCourier(@RequestBody Courier courier) {
        courierService.addCourier(courier);
        return new ResponseEntity<>("Courier is added successfully", HttpStatus.OK);
    }

    // create many couriers at once

    @PostMapping(path = "couriers/addcouriers")
    ResponseEntity<String> addManyCouriers(@RequestBody List<Courier> couriers) {
        courierService.createManyCouriers(couriers);
        return new ResponseEntity<>("Couriers added successfully", HttpStatus.OK);
    }


    // get one courier by id

    @RequestMapping(path = "couriers/{id}")
    Courier getOneCourier(@PathVariable("id") UUID id) {
        return courierService.getOneCourier(id);
    }

}

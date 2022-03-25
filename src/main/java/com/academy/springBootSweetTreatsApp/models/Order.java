package com.academy.springBootSweetTreatsApp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
public class Order {
    private UUID id;
    private LocalTime deliveryTime;
    private int distanceInMiles;
    private boolean requireRefrigeration;

    public Order(String deliveryTime, int distanceInMiles, boolean requireRefrigeration) {
        this.id = UUID.randomUUID();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalTime time = LocalTime.parse(deliveryTime, formatter);
        this.deliveryTime = time;
        this.requireRefrigeration = requireRefrigeration;
        this.distanceInMiles = distanceInMiles;
    }

}

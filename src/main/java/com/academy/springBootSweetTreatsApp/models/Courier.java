package com.academy.springBootSweetTreatsApp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
public class Courier {
    private UUID id;
    private String name;
    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private int distanceInMiles;
    private boolean refrigerated;
    private double chargePerMile;
    private boolean preferred;


    public Courier(String name, String shiftStart, String shiftEnd, int distanceInMiles, boolean refrigerated, double chargePerMile, boolean preferred) {
        this.id = UUID.randomUUID();
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalTime start = LocalTime.parse(shiftStart, formatter);
        LocalTime end = LocalTime.parse(shiftEnd, formatter);
        this.shiftStart = start;
        this.shiftEnd = end;
        this.distanceInMiles = distanceInMiles;
        this.refrigerated = refrigerated;
        this.chargePerMile = chargePerMile;
        this.preferred = preferred;
    }

    @Override
    public String toString() {
        return this.getName() + " charges  " + this.getChargePerMile();
    }

}



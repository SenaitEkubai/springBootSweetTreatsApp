package com.academy.springBootSweetTreatsApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


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


    public Courier(@JsonProperty("id") UUID id,@JsonProperty("name") String name, @JsonProperty("shiftStart") String shiftStart, @JsonProperty("shiftEnd") String shiftEnd, @JsonProperty("distanceInMiles") int distanceInMiles,
                               @JsonProperty("refrigerated") boolean refrigerated, @JsonProperty("chargePerMile") double chargePerMile, @JsonProperty("preferred") boolean preferred) {
        id = UUID.randomUUID();
         this.id=id;
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



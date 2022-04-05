package com.academy.springBootSweetTreatsApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@Document
public class Courier {
    @Id
    private String id;
    private String name;
    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private int distanceInMiles;
    private boolean refrigerated;
    private double chargePerMile;
    private boolean preferred;
    @Override
    public String toString() {
        return this.getName() + " charges  " + this.getChargePerMile();
    }

}



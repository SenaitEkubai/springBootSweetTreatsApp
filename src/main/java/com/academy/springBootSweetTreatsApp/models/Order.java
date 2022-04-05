package com.academy.springBootSweetTreatsApp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@Document
public class Order {
    @Id
    private String id;
    private LocalTime deliveryTime;
    private int distanceInMiles;
    private boolean requireRefrigeration;
}

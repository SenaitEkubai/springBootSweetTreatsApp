package com.academy.springBootSweetTreatsApp.exceptions;

public class NoCouriersFound extends RuntimeException{
    public NoCouriersFound(String message) {
        super(message);
    }
}

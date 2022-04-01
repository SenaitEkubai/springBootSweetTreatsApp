package com.academy.springBootSweetTreatsApp.exceptions;

public class OrderNotFound extends RuntimeException{
    public OrderNotFound(String message) {
        super(message);
    }
}

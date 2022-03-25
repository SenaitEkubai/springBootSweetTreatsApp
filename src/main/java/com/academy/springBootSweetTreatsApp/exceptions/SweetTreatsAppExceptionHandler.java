package com.academy.springBootSweetTreatsApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class SweetTreatsAppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CourierNotFound.class)
    public ResponseEntity<Object> handleCourierNotFound(CourierNotFound e, WebRequest request){

        return new ResponseEntity<Object>(new ApiErrorMessage("courier not found", HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }
}

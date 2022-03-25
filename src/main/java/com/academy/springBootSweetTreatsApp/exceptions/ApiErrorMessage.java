package com.academy.springBootSweetTreatsApp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiErrorMessage {
    private String message;
    private HttpStatus status;
    private LocalDateTime timeStamp;

}

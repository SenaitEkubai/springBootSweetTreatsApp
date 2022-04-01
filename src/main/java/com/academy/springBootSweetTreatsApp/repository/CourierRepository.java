package com.academy.springBootSweetTreatsApp.repository;

import com.academy.springBootSweetTreatsApp.models.Courier;

import java.util.List;
import java.util.UUID;

public interface CourierRepository {

    int insertCourier(UUID id, Courier courier);

    default int insertCourier(Courier courier){
        UUID id =UUID.randomUUID();
        return insertCourier(id, courier);
    }
    List<Courier> getAllCouriers();
}

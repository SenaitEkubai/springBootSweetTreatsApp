package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Courier;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CourierService {
    void createACourier(Courier courier);

    void createManyCouriers(List<Courier> couriers);

    List<Courier> getCouriers();

    void editCourier(String id,Courier courier);
    Optional<Courier> getCourierById(String id);
    void deleteCourier(String id);
}

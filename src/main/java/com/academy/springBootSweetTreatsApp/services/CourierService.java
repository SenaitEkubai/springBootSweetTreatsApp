package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Courier;

import java.util.List;

public interface CourierService {
    void createACourier(Courier courier);
    void createManyCouriers(List<Courier> couriers);

    void editCourier();

    void deleteCourier();

    List<Courier> getCouriers();
}

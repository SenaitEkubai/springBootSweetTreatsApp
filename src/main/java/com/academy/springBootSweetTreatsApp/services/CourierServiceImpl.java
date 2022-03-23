package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Courier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class CourierServiceImpl implements CourierService{
    List<Courier> courierList = new ArrayList<>();

    @Override
    public void createACourier(Courier courier) {
     courierList.add(courier);
    }

    @Override
    public void createManyCouriers(List<Courier> couriers) {
        courierList.addAll(couriers);
    }

    @Override
    public void editCourier() {

    }

    @Override
    public void deleteCourier() {

    }

    @Override
    public List<Courier> getCouriers() {
        return courierList;
    }
}

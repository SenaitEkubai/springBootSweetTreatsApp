package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.exceptions.CourierNotFound;
import com.academy.springBootSweetTreatsApp.models.Courier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CourierServiceImpl implements CourierService {
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
    public List<Courier> getCouriers() {
        return courierList;
    }

    @Override
    public Courier getOneCourier(UUID id) {
        Courier courier = null;
        if (courierList.isEmpty())
            throw new CourierNotFound("couriers list is empty " + id);

        for (int i = 0; i < courierList.size(); i++) {

            if (courierList.get(i).getId().equals(id)) {
                courier = courierList.get(i);
            }

        }

        return courier;
    }

    @Override
    public void editCourier() {

    }

    @Override
    public void deleteCourier() {

    }

}

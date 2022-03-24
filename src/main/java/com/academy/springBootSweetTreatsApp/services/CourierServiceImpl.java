package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Courier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CourierServiceImpl implements CourierService {
    private static final Logger LOGGER = Logger.getLogger(CourierServiceImpl.class.getName());
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

    @Override
    public Courier getOneCourier(UUID id) {
        Courier courier = null;

            for (int i = 0; i < courierList.size(); i++) {
                if(courierList.get(i).getId().equals(id)){
                    courier= courierList.get(i);
                }

            }

        return courier;
    }


    // suitable couriers


}

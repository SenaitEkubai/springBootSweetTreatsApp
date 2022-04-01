package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.exceptions.CourierNotFound;
import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.repository.CourierRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CourierServiceImpl implements CourierService {
    @Autowired
    private final CourierRepository courierRepository;

    public int addCourier(Courier courier){
        return courierRepository.insertCourier(courier);
    }

    // to be removed later
    List<Courier> courierList;

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
        return courierRepository.getAllCouriers();
    }

    @Override
    public Courier getOneCourier(UUID id) {
        Courier courier = null;

        for (int i = 0; i < courierList.size(); i++) {

            if (courierList.get(i).getId().equals(id)) {
                courier = courierList.get(i);
            }

        }
        if (courier==null)
            throw new CourierNotFound("no couriers found");

        return courier;
    }

    @Override
    public void editCourier() {

    }

    @Override
    public void deleteCourier() {

    }

}

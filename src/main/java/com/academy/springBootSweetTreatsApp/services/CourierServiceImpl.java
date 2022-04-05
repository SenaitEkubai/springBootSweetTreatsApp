package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.exceptions.CourierNotFound;
import com.academy.springBootSweetTreatsApp.exceptions.NoCouriersFound;
import com.academy.springBootSweetTreatsApp.exceptions.OrderNotFound;
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
    public CourierRepository courierRepository;

    @Override
    public void createACourier(Courier courier) {
        courierRepository.insert(courier);
    }

    @Override
    public void deleteCourier(String id) {
        courierRepository.deleteById(id);

    }

    public Optional<Courier> getCourierById(String id) {
        return courierRepository.findById(id);
    }

    @Override
    public List<Courier> getCouriers() {
        if(courierRepository.count()==0)
            throw new NoCouriersFound("No couriers found");
        return courierRepository.findAll();
    }

    @Override
    public void createManyCouriers(List<Courier> couriers) {
        courierRepository.insert(couriers);
    }

    @Override
    public void editCourier() {

    }


}

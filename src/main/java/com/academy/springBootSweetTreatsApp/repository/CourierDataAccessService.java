package com.academy.springBootSweetTreatsApp.repository;

import com.academy.springBootSweetTreatsApp.models.Courier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public class CourierDataAccessService implements CourierRepository{
    private static List<Courier> db = new ArrayList<>();
    @Override
    public int insertCourier(UUID id, Courier courier) {
         db.add(courier);
         return 1;
    }

    @Override
    public List<Courier> getAllCouriers() {
        return db;
    }


}

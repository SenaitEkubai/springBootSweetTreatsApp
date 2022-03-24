package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SweetTreatsServiceImpl implements SweetTreatsService {
    @Autowired
    CourierService courierService;
    @Autowired
    OrderService orderService;

    @Override
    public List<Courier> suitableCouriers(UUID orderId) {
        List<Courier> suitableCouriers = new ArrayList<>();
        Order order = orderService.getOneOrder(orderId);
        System.out.println(order);
        suitableCouriers = courierService.getCouriers().stream()
                .filter(courier -> order.getDeliveryTime().isAfter(courier.getShiftStart()) && order.getDeliveryTime().isBefore(courier.getShiftEnd()))
                .filter(courier -> order.getDistanceInMiles() <= courier.getDistanceInMiles())
                .filter(courier -> courier.isRefrigerated() == order.isRequireRefrigeration())
                .sorted(Comparator.comparingDouble(Courier::getChargePerMile))
                .collect(Collectors.toList());


        return suitableCouriers;
    }

    @Override
    public Courier cheapestCourier(UUID id) {
        Order order = orderService.getOneOrder(id);
        List<Courier> suitableCouriers = suitableCouriers(id);
        List<Courier> sortedSuitableList = suitableCouriers.stream()
                .sorted((Courier courier1, Courier courier2) -> {
                    if (courier1.isPreferred() && courier1.getChargePerMile() * order.getDistanceInMiles() - courier2.getChargePerMile() * order.getDistanceInMiles() <= 1) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .collect(Collectors.toList());
        return sortedSuitableList.get(0);
    }
}

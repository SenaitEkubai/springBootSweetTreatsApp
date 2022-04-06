package com.academy.springBootSweetTreatsApp.services;

import com.academy.springBootSweetTreatsApp.exceptions.CourierNotFound;
import com.academy.springBootSweetTreatsApp.exceptions.NoCouriersFound;
import com.academy.springBootSweetTreatsApp.models.Courier;
import com.academy.springBootSweetTreatsApp.models.Order;
import com.academy.springBootSweetTreatsApp.repository.CourierRepository;
import com.academy.springBootSweetTreatsApp.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SweetTreatsServiceImpl implements SweetTreatsService {
    @Autowired
    CourierRepository courierRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CourierServiceImpl courierService;
    @Autowired
    OrderServiceImpl orderService;

    public List<Courier> suitableCouriers(Order order) {
        List<Courier> suitableCouriers = null;
        try {
            suitableCouriers = courierService.getCouriers().stream()
                    .filter(courier -> order.getDeliveryTime().isAfter(courier.getShiftStart()) && order.getDeliveryTime().isBefore(courier.getShiftEnd()))
                    .filter(courier -> order.getDistanceInMiles() <= courier.getDistanceInMiles())
                    .filter(courier -> courier.isRefrigerated() == order.isRequireRefrigeration())
                    .sorted(Comparator.comparingDouble(Courier::getChargePerMile))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NoCouriersFound("no courier found");
        }

        return suitableCouriers;
    }

    @Override
    public Courier cheapestCourier(Order order) {
        List<Courier> suitableCouriers = suitableCouriers(order);
        if (suitableCouriers.isEmpty())
            throw new CourierNotFound("no courier found");

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

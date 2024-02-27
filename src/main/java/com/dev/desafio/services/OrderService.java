package com.dev.desafio.services;

import com.dev.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){
        return order.getBasic() - ((order.getDiscount() * order.getBasic()) / 100)
        + shippingService.shipment(order.getBasic())
                ;
    }

}

package bx.cnsr.corentsu.ciclos.oscor.orders.application.services;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    OrdersReadOnlyRepository ordersReadOnlyRepository;

    public void createOrder() {
        Order order = Order.builder().build();
        ordersReadOnlyRepository.createOrder(order);
    }
}

package bx.cnsr.corentsu.oscor.orders.application.services;

import bx.cnsr.corentsu.oscor.orders.domain.Order;
import bx.cnsr.corentsu.oscor.orders.domain.OrderAggregate;
import bx.cnsr.corentsu.oscor.orders.infrastructure.repository.OrdersROMongoRepository;
import bx.cnsr.corentsu.oscor.orders.infrastructure.repository.OrdersReadOnlyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    OrdersReadOnlyRepository ordersReadOnlyRepository;

    public void createOrder() {
        Order order = Order.builder().build();
        ordersReadOnlyRepository.createOrder(order);
    }
}

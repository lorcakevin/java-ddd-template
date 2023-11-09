package bx.cnsr.corentsu.oscor.orders.application.services;

import bx.cnsr.corentsu.oscor.orders.domain.entity.Order;
import bx.cnsr.corentsu.oscor.orders.infraestructure.repository.OrdersRORepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService implements IOrderService {

    @Autowired
    OrdersRORepository ordersRORepository;

    public void findOrderById(String id) {
        ordersRORepository.findById(id);
    }

    public void createOrder() {
        Order order = Order.builder().build();

        ordersRORepository.save(order);
    }
}

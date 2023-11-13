package bx.cnsr.corentsu.oscor.orders.infrastructure.controller;

import bx.cnsr.corentsu.oscor.orders.application.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping("orders/{id}")
    public void getOrderById(String id) {
        orderService.findOrderById(id);
    }

    @PostMapping
    public void createOrder() {

    }

}

package bx.cnsr.corentsu.oscor.orders.domain.repository;

import bx.cnsr.corentsu.oscor.orders.domain.Order;

public interface IOrdersReadOnlyRepository {

    void createOrder(Order order);
}

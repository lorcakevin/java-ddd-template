package bx.cnsr.corentsu.ciclos.oscor.orders.domain.repository;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderReadOnlyRepository {

    void insertOrder(Order order);

}

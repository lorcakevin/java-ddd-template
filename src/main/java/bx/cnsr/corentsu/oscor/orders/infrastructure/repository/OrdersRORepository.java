package bx.cnsr.corentsu.oscor.orders.infrastructure.repository;

import bx.cnsr.corentsu.oscor.orders.domain.VO.OrderId;
import bx.cnsr.corentsu.oscor.orders.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRORepository extends MongoRepository<OrderId, Order> {

}

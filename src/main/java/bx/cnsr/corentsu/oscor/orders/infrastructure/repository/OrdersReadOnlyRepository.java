package bx.cnsr.corentsu.oscor.orders.infrastructure.repository;

import bx.cnsr.corentsu.oscor.orders.domain.Order;
import bx.cnsr.corentsu.oscor.orders.domain.repository.IOrdersReadOnlyRepository;
import bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity.OrderReadOnlyDTO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersReadOnlyRepository implements IOrdersReadOnlyRepository {
    @Autowired
    OrdersROMongoRepository ordersROMongoRepo;

    @Override
    public void createOrder(Order order) {
        //lógica para insertar una orden de servicio en la base de datos
        //Instanciación de nuevo DTO en base a Order
        OrderReadOnlyDTO orderDTO = OrderReadOnlyDTO.builder()
                .orderId(order.getOrderId())
                .volume(order.getVolume())
                .state(order.getState())
                .build();

        ordersROMongoRepo.save(orderDTO);
    }
}

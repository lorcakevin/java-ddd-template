package bx.cnsr.corentsu.oscor.orders.infrastructure.repository;

import bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity.OrderReadOnlyDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersROMongoRepository extends MongoRepository<OrderReadOnlyDTO, ObjectId> {

}

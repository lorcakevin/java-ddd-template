package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository;

import bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity.OrderReadOnlyDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderReadOnlyMongoRepository extends MongoRepository<OrderReadOnlyDTO, ObjectId> {

}

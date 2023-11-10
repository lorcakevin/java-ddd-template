package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders-readonly")
public class OrderReadOnly {

    @BsonId
    @Indexed(name = "_id_", direction = IndexDirection.ASCENDING, unique = true)
    private ObjectId _id;
    @Indexed(name = "order_id", direction = IndexDirection.ASCENDING, unique = true)
    private String orderId;
    private String emissionDate;
    private int quantityPackages;
    private String serviceType;
    private String serviceDesc;
    private String productType;
    private String productDesc;
    private String productFamily;
    private List<String> references;
    private String observation;
    private String codeState;
    private String state;
    @Indexed(name = "reference_order", direction = IndexDirection.ASCENDING, unique = false)
    private String referenceOrder;
    private String promiseDate;
    private boolean isDangerousShipping;
    private double weight;
    private double volume;
    private double declaredValue;
    private Seller seller;
    private Buyer buyer;
    private Cod cod;
    private Dd dd;
    private Insurance insurance;
    private Shipping shipping;
    private List<Package> packages;
    private TaxDocument taxDocument;
}


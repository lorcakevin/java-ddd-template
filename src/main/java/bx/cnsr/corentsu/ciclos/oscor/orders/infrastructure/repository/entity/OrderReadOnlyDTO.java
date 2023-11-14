package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "orders-readonly")
public class OrderReadOnlyDTO {

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
    private SellerDTO seller;
    private BuyerDTO buyer;
    private CodDTO cod;
    private DdDTO dd;
    private InsuranceDTO insurance;
    private ShippingDTO shipping;
    private List<PackageDTO> packages;
    private TaxDocumentDTO taxDocument;
}


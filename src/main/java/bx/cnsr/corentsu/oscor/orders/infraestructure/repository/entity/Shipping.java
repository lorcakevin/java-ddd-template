package bx.cnsr.corentsu.oscor.orders.infraestructure.repository.entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {

    private String paymentType;
    private String paymentTypeDesc;
    private String tariff;
    private double shippingCost;
    private double discount;
    private double freight;
    private double tax;
}

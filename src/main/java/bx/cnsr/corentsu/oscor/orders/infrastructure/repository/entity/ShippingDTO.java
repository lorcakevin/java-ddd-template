package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingDTO {

    private String paymentType;
    private String paymentTypeDesc;
    private String tariff;
    private double shippingCost;
    private double discount;
    private double freight;
    private double tax;
}

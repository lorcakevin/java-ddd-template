package bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

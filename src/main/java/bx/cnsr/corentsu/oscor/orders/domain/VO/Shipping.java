package bx.cnsr.corentsu.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

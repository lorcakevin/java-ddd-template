package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Shipping;
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

    public ShippingDTO(Shipping shipping) {
        paymentType = getPaymentType();
        paymentTypeDesc = getPaymentTypeDesc();
        tariff = getTariff();
        shippingCost = getShippingCost();
        discount = getDiscount();
        freight = getFreight();
        tax = getTax();
    }

}

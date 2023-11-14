package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Detail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDTO {

    private int quantity;
    private String product;
    private double net;
    private double tax;
    private double total;

    public DetailDTO(Detail detail) {
        quantity = detail.getQuantity();
        product = detail.getProduct();
        net = detail.getNet();
        tax = detail.getTax();
        total = detail.getTotal();
    }

}

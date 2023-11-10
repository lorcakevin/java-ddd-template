package bx.cnsr.corentsu.oscor.orders.domain;

import bx.cnsr.corentsu.oscor.orders.domain.VO.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderAggregate {

    private Order order;
    private Seller seller;
    private Buyer buyer;
    private Cod cod;
    private Dd dd;
    private Insurance insurance;
    private Shipping shipping;
    private List<Package> packages;
    private TaxDocument taxDocument;

    public void addPackage(Package pkg) {
        this.packages.add(pkg);
    }

    public void calculateWeight() {
        //Uso de método protegido
        order.calculateWeight();
    }

}

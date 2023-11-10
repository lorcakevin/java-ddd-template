package bx.cnsr.corentsu.oscor.orders.domain;

import bx.cnsr.corentsu.oscor.orders.domain.VO.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

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

    protected void calculateWeight() {
        /*
            Método con nivel de acceso protegido
            para que sólo se pueda acceder a este desde
            la clase de agregado
         */
    }
}
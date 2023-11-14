package bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Detail {

    private int quantity;
    private String product;
    private double net;
    private double tax;
    private double total;

}

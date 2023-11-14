package bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cod {

    private String type;
    private String typeDesc;
    private double amount;
    private String currency;
    private String currencyName;
}


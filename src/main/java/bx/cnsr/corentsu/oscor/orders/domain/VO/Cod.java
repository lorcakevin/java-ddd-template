package bx.cnsr.corentsu.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cod {

    private String type;
    private String typeDesc;
    private double amount;
    private String currency;
    private String currencyName;
}


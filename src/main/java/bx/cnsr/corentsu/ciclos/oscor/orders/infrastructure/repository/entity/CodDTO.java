package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Cod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodDTO {

    private String type;
    private String typeDesc;
    private double amount;
    private String currency;
    private String currencyName;

    public CodDTO(Cod cod) {
        type = cod.getType();
        typeDesc = cod.getTypeDesc();
        amount = cod.getAmount();
        currency = cod.getCurrency();
        currencyName = cod.getCurrencyName();
    }
}


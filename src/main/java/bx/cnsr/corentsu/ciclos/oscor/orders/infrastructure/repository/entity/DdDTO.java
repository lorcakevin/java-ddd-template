package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Dd;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DdDTO {

    private String type;
    private String typeDesc;
    private String identifier;

    public DdDTO(Dd dd) {
        type = dd.getType();
        typeDesc = dd.getTypeDesc();
        identifier = dd.getIdentifier();
    }
}


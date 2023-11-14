package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Units;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitsDTO {

    private String weight;
    private String length;

    public UnitsDTO(Units units) {
        weight = units.getWeight();
        length = units.getLength();
    }

}


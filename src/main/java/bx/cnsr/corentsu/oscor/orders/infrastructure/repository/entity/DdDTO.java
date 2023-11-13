package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DdDTO {

    private String type;
    private String typeDesc;
    private String identifier;
}


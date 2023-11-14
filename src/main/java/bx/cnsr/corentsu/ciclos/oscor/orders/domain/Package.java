package bx.cnsr.corentsu.ciclos.oscor.orders.domain;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Units;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Package {

    private String packageId;
    private double weight;
    private double height;
    private double width;
    private double length;
    private double volume;
    private double factor;
    private Units units;
    private String codeState;
    private String state;
    private String referenceChildOrder;
    private List<Tracking> tracking;
}

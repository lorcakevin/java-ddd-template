package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geolocalization {

    private List<Double> coordinates;
}

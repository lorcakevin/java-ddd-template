package bx.cnsr.corentsu.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geolocalization {

    private List<Double> coordinates;
}


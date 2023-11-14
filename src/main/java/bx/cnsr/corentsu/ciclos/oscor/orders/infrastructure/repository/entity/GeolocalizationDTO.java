package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Geolocalization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeolocalizationDTO {

    private List<Double> coordinates;

    public GeolocalizationDTO(Geolocalization geolocalization) {
        coordinates = geolocalization.getCoordinates();
    }
}


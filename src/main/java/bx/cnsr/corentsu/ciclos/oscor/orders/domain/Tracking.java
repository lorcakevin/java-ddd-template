package bx.cnsr.corentsu.ciclos.oscor.orders.domain;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Geolocalization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tracking {

    private int trackingId;
    private String trackingDate;
    private String eventCode;
    private String eventType;
    private String location;
    private String userName;
    private String observation;
    private String createdDate;
    private Geolocalization geolocalization;
}

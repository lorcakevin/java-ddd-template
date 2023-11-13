package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingDTO {

    private int trackingId;
    private String trackingDate;
    private String eventCode;
    private String eventType;
    private String location;
    private String userName;
    private String observation;
    private String createdDate;
    private GeolocalizationDTO geolocalization;
}

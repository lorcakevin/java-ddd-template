package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.Tracking;
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

    public TrackingDTO(Tracking tracking) {
        trackingId = tracking.getTrackingId();
        trackingDate = tracking.getTrackingDate();
        eventCode = tracking.getEventCode();
        eventType = tracking.getEventType();
        location = tracking.getLocation();
        userName = tracking.getUserName();
        observation = tracking.getObservation();
        createdDate = tracking.getCreatedDate();
        geolocalization = new GeolocalizationDTO(tracking.getGeolocalization());
    }

}

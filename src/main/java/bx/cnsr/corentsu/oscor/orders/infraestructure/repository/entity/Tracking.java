package bx.cnsr.corentsu.oscor.orders.infraestructure.repository.entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.Package;
import bx.cnsr.corentsu.ciclos.oscor.orders.domain.Tracking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageDTO {

    private String packageId;
    private double weight;
    private double height;
    private double width;
    private double length;
    private double volume;
    private double factor;
    private UnitsDTO units;
    private String codeState;
    private String state;
    @Indexed(name = "package_reference_child_order", direction = IndexDirection.ASCENDING, unique = false)
    private String referenceChildOrder;
    private List<TrackingDTO> tracking;

    public PackageDTO(Package packageEntity) {
        //Mutar lista de trackings desde el dominio
        List<TrackingDTO> trackings = new ArrayList<>();
        for (Tracking tracking : packageEntity.getTracking()) {
            trackings.add(new TrackingDTO(tracking));
        }

        packageId = packageEntity.getPackageId();
        weight = packageEntity.getWeight();
        height = packageEntity.getHeight();
        width = packageEntity.getWidth();
        length = packageEntity.getLength();
        volume = packageEntity.getVolume();
        factor = packageEntity.getFactor();
        units = new UnitsDTO(packageEntity.getUnits());
        codeState = packageEntity.getCodeState();
        state = packageEntity.getState();
        referenceChildOrder = packageEntity.getReferenceChildOrder();
        tracking = trackings;
    }

}

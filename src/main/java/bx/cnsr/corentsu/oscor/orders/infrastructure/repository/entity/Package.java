package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;
import lombok.*;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @Indexed(name = "package_reference_child_order", direction = IndexDirection.ASCENDING, unique = false)
    private String referenceChildOrder;
    private List<Tracking> tracking;
}

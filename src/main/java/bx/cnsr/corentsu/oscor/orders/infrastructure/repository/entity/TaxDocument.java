package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxDocument {

    private String documentId;
    private String type;
    private String typeDesc;
    private String path;
    private Receiver receiver;
    private Detail detail;
}

package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaxDocumentDTO {

    private String documentId;
    private String type;
    private String typeDesc;
    private String path;
    private ReceiverDTO receiver;
    private DetailDTO detail;
}

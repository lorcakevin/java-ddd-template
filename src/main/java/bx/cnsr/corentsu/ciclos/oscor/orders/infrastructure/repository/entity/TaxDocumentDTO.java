package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.TaxDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxDocumentDTO {

    private String documentId;
    private String type;
    private String typeDesc;
    private String path;
    private ReceiverDTO receiver;
    private DetailDTO detail;

    public TaxDocumentDTO(TaxDocument taxDocument) {
        documentId = taxDocument.getDocumentId();
        type = taxDocument.getType();
        typeDesc = taxDocument.getTypeDesc();
        path = taxDocument.getPath();
        receiver = new ReceiverDTO(taxDocument.getReceiver());
        detail = new DetailDTO(taxDocument.getDetail());
    }

}

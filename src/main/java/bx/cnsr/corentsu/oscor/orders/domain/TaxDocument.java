package bx.cnsr.corentsu.oscor.orders.domain;

import bx.cnsr.corentsu.oscor.orders.domain.VO.Detail;
import bx.cnsr.corentsu.oscor.orders.domain.VO.Receiver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxDocument {

    private String documentId;
    private String type;
    private String typeDesc;
    private String path;
    private Receiver receiver;
    private Detail detail;

}

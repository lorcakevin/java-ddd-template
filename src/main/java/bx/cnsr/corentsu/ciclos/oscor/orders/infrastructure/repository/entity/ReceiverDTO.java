package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Receiver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverDTO {

    private String name;
    private String email;
    private AddressDTO address;

    public ReceiverDTO(Receiver receiver) {
        name = receiver.getName();
        email = receiver.getEmail();
        address = new AddressDTO(receiver.getAddress());
    }

}

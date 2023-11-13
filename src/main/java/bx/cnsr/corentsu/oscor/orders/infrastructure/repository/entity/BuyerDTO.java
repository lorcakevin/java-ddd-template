package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDTO {

    private String name;
    private String email;
    private String phone;
    private String identifier;
    private String agency;
    private AddressDTO address;
    private String fullAddress;
}

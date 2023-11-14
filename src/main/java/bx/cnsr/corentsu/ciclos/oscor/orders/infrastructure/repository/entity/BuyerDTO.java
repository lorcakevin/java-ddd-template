package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Buyer;
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

    public BuyerDTO(Buyer buyer) {
        name = buyer.getName();
        email = buyer.getEmail();
        phone = buyer.getPhone();
        identifier = buyer.getIdentifier();
        agency = buyer.getAgency();
        address = new AddressDTO(buyer.getAddress());
        fullAddress = buyer.getFullAddress();
    }
}

package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {

    private String account;
    private String name;
    private String email;
    private String phone;
    private String identifier;
    private String agency;
    private AddressDTO address;
    private String fullAddress;

    public SellerDTO(Seller seller) {
        account = seller.getAccount();
        name = seller.getName();
        email = seller.getEmail();
        phone = seller.getPhone();
        identifier = seller.getIdentifier();
        agency = seller.getAgency();
        address = new AddressDTO(seller.getAddress());
        fullAddress = seller.getFullAddress();
    }
}

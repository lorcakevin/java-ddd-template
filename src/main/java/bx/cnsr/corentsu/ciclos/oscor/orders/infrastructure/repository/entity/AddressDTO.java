package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private String street;
    private int number;
    private String block;
    private int apartament;
    private int floor;
    private String office;
    private String commune;
    private String city;
    private String region;
    private String location;
    private String postalCode;

    public AddressDTO(Address address) {
        street = address.getStreet();
        number = address.getNumber();
        block = address.getBlock();
        apartament = address.getApartament();
        floor = address.getFloor();
        office = address.getOffice();
        commune = address.getCommune();
        city = address.getCity();
        region = address.getRegion();
        location = address.getLocation();
        postalCode = address.getPostalCode();
    }
}

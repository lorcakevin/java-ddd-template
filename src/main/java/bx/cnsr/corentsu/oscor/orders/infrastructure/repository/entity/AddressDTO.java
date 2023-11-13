package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;

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
}

package bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

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

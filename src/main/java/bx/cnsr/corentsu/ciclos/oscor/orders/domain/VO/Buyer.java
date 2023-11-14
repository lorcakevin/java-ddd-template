package bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {

    private String name;
    private String email;
    private String phone;
    private String identifier;
    private String agency;
    private Address address;
    private String fullAddress;
}

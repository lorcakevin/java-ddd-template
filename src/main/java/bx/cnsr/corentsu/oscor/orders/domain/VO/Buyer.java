package bx.cnsr.corentsu.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

package bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Receiver {

    private String name;
    private String email;
    private Address address;
}

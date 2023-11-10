package bx.cnsr.corentsu.oscor.orders.infrastructure.repository.entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receiver {

    private String name;
    private String email;
    private Address address;
}

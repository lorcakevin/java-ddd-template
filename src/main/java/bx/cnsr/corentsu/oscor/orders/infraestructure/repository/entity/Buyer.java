package bx.cnsr.corentsu.oscor.orders.infraestructure.repository.entity;
import lombok.*;

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

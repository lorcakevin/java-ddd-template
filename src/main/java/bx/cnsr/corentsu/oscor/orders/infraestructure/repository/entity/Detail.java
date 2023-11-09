package bx.cnsr.corentsu.oscor.orders.infraestructure.repository.entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {

    private int quantity;
    private String product;
    private double net;
    private double tax;
    private double total;
}

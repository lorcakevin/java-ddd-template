package bx.cnsr.corentsu.oscor.orders.infraestructure.repository.entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

    private String invoiceNumber;
    private double amount;
}

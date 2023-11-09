package bx.cnsr.corentsu.oscor.orders.infraestructure.repository.entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cod {

    private String type;
    private String typeDesc;
    private double amount;
    private String currency;
    private String currencyName;
}


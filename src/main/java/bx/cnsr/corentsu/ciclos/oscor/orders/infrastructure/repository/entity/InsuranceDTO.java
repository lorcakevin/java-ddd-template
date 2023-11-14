package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.VO.Insurance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDTO {

    private String invoiceNumber;
    private double amount;

    public InsuranceDTO(Insurance insurance) {
        invoiceNumber = insurance.getInvoiceNumber();
        amount = insurance.getAmount();
    }

}

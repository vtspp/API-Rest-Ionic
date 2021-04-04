package com.vtspp.api.ionic.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity(name = "tb_payment_card")
@JsonTypeName("paymentCard")
public class PaymentCard extends Payment{

    @NotEmpty(message = "Informe o número de parcelas")
    private Integer numberOfInstallments;

    public PaymentCard() {
    }

    public PaymentCard(Integer id, Integer status, Order order, Integer numberOfInstallments) {
        super(id, status, order);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }
}

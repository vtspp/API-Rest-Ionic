package com.vtspp.api.ionic.domain;

import javax.persistence.Entity;

@Entity(name = "tb_payment_card")
public class PaymentCard extends Payment{

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

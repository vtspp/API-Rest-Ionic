package com.vtspp.api.ionic.domain;

import com.vtspp.api.ionic.enums.StatusPayment;

import javax.persistence.Entity;

@Entity(name = "tb_payment_card")
public class PaymentCard extends Payment{

    private Integer numberOfInstallments;

    public PaymentCard() {
    }

    public PaymentCard(Integer id, StatusPayment status, Order order, Integer numberOfInstallments) {
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

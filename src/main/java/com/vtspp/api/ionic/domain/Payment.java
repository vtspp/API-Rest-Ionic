package com.vtspp.api.ionic.domain;

import com.vtspp.api.ionic.enums.StatusPayment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private StatusPayment status;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    public  Payment (){
    }

    public Payment(Integer id, StatusPayment status, Order order) {
        this.id = id;
        this.status = status;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusPayment getStatus() {
        return status;
    }

    public void setStatus(StatusPayment status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
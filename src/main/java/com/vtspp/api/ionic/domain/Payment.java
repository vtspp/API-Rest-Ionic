package com.vtspp.api.ionic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vtspp.api.ionic.enums.StatusPayment;
import com.vtspp.api.ionic.util.Converter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "tb_payment")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @JoinColumn(name = "status_id")
    private Integer status;

    @OneToOne(mappedBy = "payment")
    @JoinColumn(name = "order_id")
    @MapsId
    @JsonIgnore
    private Order order;

    public  Payment (){
    }

    public Payment(Integer id, Integer status, Order order) {
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

    @Enumerated(EnumType.ORDINAL)
    public String getStatus() {
        return Converter.toEnum(StatusPayment.class.getEnumConstants(), status).getDescription();
    }

    public void setStatus(Integer status) {
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
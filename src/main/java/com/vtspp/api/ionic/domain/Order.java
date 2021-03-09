package com.vtspp.api.ionic.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime instant;

    @ManyToMany
     private List<Product> itens = new ArrayList<>();

    @OneToOne
    private Client client;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private  Payment payment;

    @ManyToOne
    @JoinColumn(name = "delivery_andress_id")
    private Andress deliveryAddress;

    public Order () {
    }

    public Order(Integer id, LocalDateTime instant, Client client, Payment payment, Andress deliveryAddress) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public void setInstant(LocalDateTime instant) {
        this.instant = instant;
    }

    public List<Product> getItens() {
        return itens;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Andress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Andress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
package com.vtspp.api.ionic.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "tb_telephone")
public class Telephone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String number;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @MapsId
    private Client client;

    public Telephone () {
    }

    public Telephone(Integer id, String number, Client client) {
        this.id = id;
        this.number = number;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telephone telephone = (Telephone) o;
        return id.equals(telephone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

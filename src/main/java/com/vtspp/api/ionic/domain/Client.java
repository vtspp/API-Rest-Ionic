package com.vtspp.api.ionic.domain;

import com.vtspp.api.ionic.enums.TypeClient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String CfpOuCnpj;

    @Enumerated(EnumType.ORDINAL)
    private TypeClient typeClient;

    @OneToMany
    private List<Andress> andresses = new ArrayList<>();

    @OneToMany
    private List<Order> orders = new ArrayList<>();

    @OneToMany
    private List<Telephone> telephones = new ArrayList<>();

    public Client (){
    }

    public Client(Integer id, String name, String email, String cfpOuCnpj, TypeClient typeClient) {
        this.id = id;
        this.name = name;
        this.email = email;
        CfpOuCnpj = cfpOuCnpj;
        this.typeClient = typeClient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCfpOuCnpj() {
        return CfpOuCnpj;
    }

    public void setCfpOuCnpj(String cfpOuCnpj) {
        CfpOuCnpj = cfpOuCnpj;
    }

    public TypeClient getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient;
    }

    public List<Andress> getAndresses() {
        return andresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

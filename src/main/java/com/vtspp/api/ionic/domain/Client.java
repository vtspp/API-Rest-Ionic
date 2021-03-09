package com.vtspp.api.ionic.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vtspp.api.ionic.enums.TypeClient;
import com.vtspp.api.ionic.util.Converter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String CfpOuCnpj;

    private Integer typeClient;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Andress> andresses = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private Set<Telephone> telephones = new HashSet<>();

    public Client (){
    }

    public Client(Integer id, String name, String email, String cfpOuCnpj, TypeClient typeClient) {
        this.id = id;
        this.name = name;
        this.email = email;
        CfpOuCnpj = cfpOuCnpj;
        this.typeClient = typeClient.getCode();
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

    @Enumerated(EnumType.ORDINAL)
    public TypeClient getTypeClient() {
        return Converter.toEnum(TypeClient.class.getEnumConstants(), typeClient);
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient.getCode();
    }

    public List<Andress> getAndresses() {
        return andresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Set<Telephone> getTelephones() {
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

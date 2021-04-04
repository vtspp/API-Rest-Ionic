package com.vtspp.api.ionic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtspp.api.ionic.enums.TypeClient;
import com.vtspp.api.ionic.util.Converter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.*;

@Entity(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O campo nome não deve ser vazio")
    @Length(min = 2, max = 60, message = "O nome deve ter entre 2 à 60 caracteres")
    private String name;

    @Email(message = "Este email não é valido")
    @NotEmpty(message = "O campo email não deve ser vazio")
    private String email;

    private String cfpOuCnpj;

    private Integer typeClient;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Andress> andresses = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private Set<Telephone> telephones = new HashSet<>();

    public Client (){
    }

    public Client(Integer id, String name, String email, String cfpOuCnpj, Integer typeClient) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cfpOuCnpj = cfpOuCnpj;
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
        return cfpOuCnpj;
    }

    public void setCfpOuCnpj(String cfpOuCnpj) {
        this.cfpOuCnpj = cfpOuCnpj;
    }

    @Enumerated(EnumType.ORDINAL)
    public String getTypeClient() {
        return Converter.toEnum(TypeClient.class.getEnumConstants(), typeClient).getDescription();
    }

    public void setTypeClient(Integer typeClient) {
        this.typeClient = typeClient;
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

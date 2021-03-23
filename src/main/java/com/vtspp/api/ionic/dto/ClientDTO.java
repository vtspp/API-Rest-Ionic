package com.vtspp.api.ionic.dto;

import com.vtspp.api.ionic.domain.Client;

import java.io.Serializable;
import java.util.Objects;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String email;
    private String cfpOuCnpj;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.cfpOuCnpj = client.getCfpOuCnpj();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientDTO)) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return getId().equals(clientDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

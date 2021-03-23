package com.vtspp.api.ionic.dto;

import com.vtspp.api.ionic.domain.Telephone;

import java.io.Serializable;
import java.util.Objects;

public class TelephoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String number;

    public TelephoneDTO(Telephone telephone) {
        this.id = telephone.getId();
        this.number = telephone.getNumber();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelephoneDTO)) return false;
        TelephoneDTO that = (TelephoneDTO) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

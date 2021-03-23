package com.vtspp.api.ionic.dto;

import com.vtspp.api.ionic.domain.Andress;

import java.io.Serializable;
import java.util.Objects;

public class AndressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String street;
    private Integer number;
    private String complement;
    private String district;
    private String zipCode;

    public AndressDTO(Andress andress) {
        this.id = andress.getId();
        this.street = andress.getStreet();
        this.number = andress.getNumber();
        this.complement = andress.getComplement();
        this.district = andress.getDistrict();
        this.zipCode = andress.getZipCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AndressDTO)) return false;
        AndressDTO that = (AndressDTO) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

package com.vtspp.api.ionic.dto;

import com.vtspp.api.ionic.domain.City;

import java.io.Serializable;
import java.util.Objects;

public class CityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public CityDTO(City city) {
        this.id = city.getId();
        this.name = city.getName();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityDTO)) return false;
        CityDTO cityDTO = (CityDTO) o;
        return getId().equals(cityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

package com.vtspp.api.ionic.dto;

import com.vtspp.api.ionic.domain.State;

import java.io.Serializable;
import java.util.Objects;

public class StateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public StateDTO(State state) {
        this.id = state.getId();
        this.name = state.getName();
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
        if (!(o instanceof StateDTO)) return false;
        StateDTO stateDTO = (StateDTO) o;
        return getId().equals(stateDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

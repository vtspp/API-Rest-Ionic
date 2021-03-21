package com.vtspp.api.ionic.dto;

import com.vtspp.api.ionic.domain.Category;

import java.io.Serializable;
import java.util.Objects;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
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
        if (!(o instanceof CategoryDTO)) return false;
        CategoryDTO that = (CategoryDTO) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

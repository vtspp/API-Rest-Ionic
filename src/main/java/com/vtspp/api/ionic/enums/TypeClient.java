package com.vtspp.api.ionic.enums;

import static com.vtspp.api.ionic.util.Check.isNull;

public enum  TypeClient {

    PHYSICAL_PERSON  (0, "pessoa_fisíca"),
    JURIDICAL_PERSON  (1, "pessoa_juridíca");

    private Integer code;
    private String description;

    TypeClient(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
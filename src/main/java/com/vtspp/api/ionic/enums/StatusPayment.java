package com.vtspp.api.ionic.enums;

public enum StatusPayment {

    PENDING (0, "pendente"),
    PAID (1, "quitado"),
    CANCELED (2, "cancelado");

    private Integer code;
    private String description;

    StatusPayment(Integer code, String description) {
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

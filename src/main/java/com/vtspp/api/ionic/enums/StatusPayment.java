package com.vtspp.api.ionic.enums;

public enum StatusPayment {

    PENDING (0, "Pendente"),
    PAID (1, "Quitado"),
    CANCELED (2, "Cancelado");

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

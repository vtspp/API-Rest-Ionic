package com.vtspp.api.ionic.service.exceptions.andress;

import java.io.Serializable;

public class AndressUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public AndressUpdateException(String message) {
        super(message);
    }
}

package com.vtspp.api.ionic.service.exceptions.andress;

import java.io.Serializable;

public class AndressNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public AndressNotFoundException(String message) {
        super(message);
    }
}

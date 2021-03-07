package com.vtspp.api.ionic.service.exceptions.Andress;

import java.io.Serializable;

public class AndressNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public AndressNotSaveException(String message) {
        super(message);
    }
}

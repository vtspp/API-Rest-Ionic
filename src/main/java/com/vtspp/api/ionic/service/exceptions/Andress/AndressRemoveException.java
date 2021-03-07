package com.vtspp.api.ionic.service.exceptions.Andress;

import java.io.Serializable;

public class AndressRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public AndressRemoveException(String message) {
        super(message);
    }
}

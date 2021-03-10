package com.vtspp.api.ionic.service.exceptions.andress;

import java.io.Serializable;

public class AndressFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public AndressFindAllException(String message) {
        super(message);
    }
}

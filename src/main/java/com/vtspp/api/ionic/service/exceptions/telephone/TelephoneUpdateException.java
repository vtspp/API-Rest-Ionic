package com.vtspp.api.ionic.service.exceptions.telephone;

import java.io.Serializable;

public class TelephoneUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public TelephoneUpdateException(String message) {
        super(message);
    }
}

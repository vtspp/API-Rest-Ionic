package com.vtspp.api.ionic.service.exceptions.telephone;

import java.io.Serializable;

public class TelephoneNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public TelephoneNotFoundException(String message) {
        super(message);
    }
}

package com.vtspp.api.ionic.service.exceptions.telephone;

import java.io.Serializable;

public class TelephoneNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public TelephoneNotSaveException(String message) {
        super(message);
    }
}

package com.vtspp.api.ionic.service.exceptions.telephone;

import java.io.Serializable;

public class TelephoneRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public TelephoneRemoveException(String message) {
        super(message);
    }
}

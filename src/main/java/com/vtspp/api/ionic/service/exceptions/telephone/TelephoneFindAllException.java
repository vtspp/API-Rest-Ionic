package com.vtspp.api.ionic.service.exceptions.telephone;

import java.io.Serializable;

public class TelephoneFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public TelephoneFindAllException(String message) {
        super(message);
    }
}

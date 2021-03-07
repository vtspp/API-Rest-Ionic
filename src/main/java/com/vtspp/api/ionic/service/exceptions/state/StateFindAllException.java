package com.vtspp.api.ionic.service.exceptions.state;

import java.io.Serializable;

public class StateFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public StateFindAllException(String message) {
        super(message);
    }
}

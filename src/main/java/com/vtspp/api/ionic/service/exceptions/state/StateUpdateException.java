package com.vtspp.api.ionic.service.exceptions.state;

import java.io.Serializable;

public class StateUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public StateUpdateException(String message) {
        super(message);
    }
}

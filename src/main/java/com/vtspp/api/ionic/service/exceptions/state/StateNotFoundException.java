package com.vtspp.api.ionic.service.exceptions.state;

import java.io.Serializable;

public class StateNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public StateNotFoundException(String message) {
        super(message);
    }
}

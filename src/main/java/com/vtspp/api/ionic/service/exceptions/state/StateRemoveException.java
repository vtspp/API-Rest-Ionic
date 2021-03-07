package com.vtspp.api.ionic.service.exceptions.state;

import java.io.Serializable;

public class StateRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public StateRemoveException(String message) {
        super(message);
    }
}

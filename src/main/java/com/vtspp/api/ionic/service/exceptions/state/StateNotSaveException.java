package com.vtspp.api.ionic.service.exceptions.state;

import java.io.Serializable;

public class StateNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public StateNotSaveException(String message) {
        super(message);
    }
}

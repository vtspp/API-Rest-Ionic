package com.vtspp.api.ionic.service.exceptions.client;

import java.io.Serializable;

public class ClientNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ClientNotSaveException(String message) {
        super(message);
    }
}

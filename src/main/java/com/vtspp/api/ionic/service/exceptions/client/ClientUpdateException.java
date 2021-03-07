package com.vtspp.api.ionic.service.exceptions.client;

import java.io.Serializable;

public class ClientUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ClientUpdateException(String message) {
        super(message);
    }
}

package com.vtspp.api.ionic.service.exceptions.client;

import java.io.Serializable;

public class ClientNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(String message) {
        super(message);
    }
}

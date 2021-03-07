package com.vtspp.api.ionic.service.exceptions.client;

import java.io.Serializable;

public class ClientFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ClientFindAllException(String message) {
        super(message);
    }
}

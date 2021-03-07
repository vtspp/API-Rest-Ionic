package com.vtspp.api.ionic.service.exceptions.client;

import java.io.Serializable;

public class ClientRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ClientRemoveException(String message) {
        super(message);
    }
}

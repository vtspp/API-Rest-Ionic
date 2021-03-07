package com.vtspp.api.ionic.service.exceptions.order;

import java.io.Serializable;

public class OrderNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public OrderNotFoundException(String message) {
        super(message);
    }
}

package com.vtspp.api.ionic.service.exceptions.order;

import java.io.Serializable;

public class OrderNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public OrderNotSaveException(String message) {
        super(message);
    }
}

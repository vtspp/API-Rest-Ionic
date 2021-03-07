package com.vtspp.api.ionic.service.exceptions.order;

import java.io.Serializable;

public class OrderUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public OrderUpdateException(String message) {
        super(message);
    }
}

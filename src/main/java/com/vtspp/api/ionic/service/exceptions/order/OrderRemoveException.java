package com.vtspp.api.ionic.service.exceptions.order;

import java.io.Serializable;

public class OrderRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public OrderRemoveException(String message) {
        super(message);
    }
}

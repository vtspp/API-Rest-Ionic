package com.vtspp.api.ionic.service.exceptions.order;

import java.io.Serializable;

public class OrderFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public OrderFindAllException(String message) {
        super(message);
    }
}

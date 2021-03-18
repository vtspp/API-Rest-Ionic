package com.vtspp.api.ionic.service.exceptions.item_order;

import java.io.Serializable;

public class ItemOrderNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ItemOrderNotFoundException(String message) {
        super(message);
    }
}

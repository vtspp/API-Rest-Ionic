package com.vtspp.api.ionic.service.exceptions.item_order;

import java.io.Serializable;

public class ItemOrderRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ItemOrderRemoveException(String message) {
        super(message);
    }
}

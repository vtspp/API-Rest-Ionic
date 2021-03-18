package com.vtspp.api.ionic.service.exceptions.item_order;

import java.io.Serializable;

public class ItemOrderNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ItemOrderNotSaveException(String message) {
        super(message);
    }
}

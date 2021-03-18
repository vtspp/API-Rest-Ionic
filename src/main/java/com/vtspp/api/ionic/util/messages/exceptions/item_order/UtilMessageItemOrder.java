package com.vtspp.api.ionic.util.messages.exceptions.item_order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageItemOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.itemOrder}")
    private  String MESSAGE_ERROR_FIND_ONE_ITEM_ORDER ;

    @Value(value = "${message.error.save.itemOrder}")
    private  String MESSAGE_ERROR_SAVE_ITEM_ORDER ;

    @Value(value = "${message.error.remove.itemOrder}")
    private  String MESSAGE_ERROR_REMOVE_ITEM_ORDER ;

    @Value(value = "${message.error.update.itemOrder}")
    private  String MESSAGE_ERROR_UPDATE_ITEM_ORDER ;

    @Value(value = "${message.error.findAll.itemOrder}")
    private  String MESSAGE_ERROR_FIND_ALL_ITEM_ORDER ;

    public  String getMessageErrorFindOneItemOrder() {
        return MESSAGE_ERROR_FIND_ONE_ITEM_ORDER;
    }

    public  String getMessageErrorSaveItemOrder() {
        return MESSAGE_ERROR_SAVE_ITEM_ORDER;
    }

    public  String getMessageErrorRemoveItemOrder() {
        return MESSAGE_ERROR_REMOVE_ITEM_ORDER;
    }

    public  String getMessageErrorUpdateItemOrder() {
        return MESSAGE_ERROR_UPDATE_ITEM_ORDER;
    }

    public  String getMessageErrorFindAllItemOrder() {
        return MESSAGE_ERROR_FIND_ALL_ITEM_ORDER;
    }

}

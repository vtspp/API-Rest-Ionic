package com.vtspp.api.ionic.util.messages.exceptions.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.order}")
    private  String MESSAGE_ERROR_FIND_ONE_ORDER ;

    @Value(value = "${message.error.save.order}")
    private  String MESSAGE_ERROR_SAVE_ORDER ;

    @Value(value = "${message.error.remove.order}")
    private  String MESSAGE_ERROR_REMOVE_ORDER ;

    @Value(value = "${message.error.update.order}")
    private  String MESSAGE_ERROR_UPDATE_ORDER ;

    @Value(value = "${message.error.findAll.order}")
    private  String MESSAGE_ERROR_FIND_ALL_ORDER ;

    public  String getMessageErrorFindOneOrder() {
        return MESSAGE_ERROR_FIND_ONE_ORDER;
    }

    public  String getMessageErrorSaveOrder() {
        return MESSAGE_ERROR_SAVE_ORDER;
    }

    public  String getMessageErrorRemoveOrder() {
        return MESSAGE_ERROR_REMOVE_ORDER;
    }

    public  String getMessageErrorUpdateOrder() {
        return MESSAGE_ERROR_UPDATE_ORDER;
    }

    public  String getMessageErrorFindAllOrder() {
        return MESSAGE_ERROR_FIND_ALL_ORDER;
    }

}

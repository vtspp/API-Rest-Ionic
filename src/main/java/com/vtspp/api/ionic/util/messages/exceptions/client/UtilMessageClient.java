package com.vtspp.api.ionic.util.messages.exceptions.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageClient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.client}")
    private String MESSAGE_ERROR_FIND_ONE_CLIENT ;

    @Value(value = "${message.error.save.client}")
    private String MESSAGE_ERROR_SAVE_CLIENT ;

    @Value(value = "${message.error.remove.client}")
    private String MESSAGE_ERROR_REMOVE_CLIENT ;

    @Value(value = "${message.error.update.client}")
    private String MESSAGE_ERROR_UPDATE_CLIENT ;

    @Value(value = "${message.error.findAll.client}")
    private String MESSAGE_ERROR_FIND_ALL_CLIENT ;

    public String getMessageErrorFindOneClient() {
        return MESSAGE_ERROR_FIND_ONE_CLIENT;
    }

    public String getMessageErrorSaveClient() {
        return MESSAGE_ERROR_SAVE_CLIENT;
    }

    public String getMessageErrorRemoveClient() {
        return MESSAGE_ERROR_REMOVE_CLIENT;
    }

    public String getMessageErrorUpdateClient() {
        return MESSAGE_ERROR_UPDATE_CLIENT;
    }

    public String getMessageErrorFindAllClient() {
        return MESSAGE_ERROR_FIND_ALL_CLIENT;
    }

}

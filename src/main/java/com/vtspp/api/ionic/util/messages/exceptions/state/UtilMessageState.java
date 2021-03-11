package com.vtspp.api.ionic.util.messages.exceptions.state;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageState implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.state}")
    private String MESSAGE_ERROR_FIND_ONE_STATE ;

    @Value(value = "${message.error.save.state}")
    private String MESSAGE_ERROR_SAVE_STATE ;

    @Value(value = "${message.error.remove.state}")
    private String MESSAGE_ERROR_REMOVE_STATE ;

    @Value(value = "${message.error.update.state}")
    private String MESSAGE_ERROR_UPDATE_STATE ;

    @Value(value = "${message.error.findAll.state}")
    private String MESSAGE_ERROR_FIND_ALL_STATE ;

    public String getMessageErrorFindOneState() {
        return MESSAGE_ERROR_FIND_ONE_STATE;
    }

    public String getMessageErrorSaveState() {
        return MESSAGE_ERROR_SAVE_STATE;
    }

    public String getMessageErrorRemoveState() {
        return MESSAGE_ERROR_REMOVE_STATE;
    }

    public String getMessageErrorUpdateState() {
        return MESSAGE_ERROR_UPDATE_STATE;
    }

    public String getMessageErrorFindAllState() {
        return MESSAGE_ERROR_FIND_ALL_STATE;
    }

}

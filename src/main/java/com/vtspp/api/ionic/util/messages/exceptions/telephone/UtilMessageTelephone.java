package com.vtspp.api.ionic.util.messages.exceptions.telephone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageTelephone implements Serializable {
    private final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.telephone}")
    private String MESSAGE_ERROR_FIND_ONE_TELEPHONE ;

    @Value(value = "${message.error.save.telephone}")
    private String MESSAGE_ERROR_SAVE_TELEPHONE ;

    @Value(value = "${message.error.remove.telephone}")
    private String MESSAGE_ERROR_REMOVE_TELEPHONE ;

    @Value(value = "${message.error.update.telephone}")
    private String MESSAGE_ERROR_UPDATE_TELEPHONE ;

    @Value(value = "${message.error.findAll.telephone}")
    private String MESSAGE_ERROR_FIND_ALL_TELEPHONE ;

    public String getMessageErrorFindOneTelephone() {
        return MESSAGE_ERROR_FIND_ONE_TELEPHONE;
    }

    public String getMessageErrorSaveTelephone() {
        return MESSAGE_ERROR_SAVE_TELEPHONE;
    }

    public String getMessageErrorRemoveTelephone() {
        return MESSAGE_ERROR_REMOVE_TELEPHONE;
    }

    public String getMessageErrorUpdateTelephone() {
        return MESSAGE_ERROR_UPDATE_TELEPHONE;
    }

    public String getMessageErrorFindAllTelephone() {
        return MESSAGE_ERROR_FIND_ALL_TELEPHONE;
    }

}

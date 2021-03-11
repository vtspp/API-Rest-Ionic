package com.vtspp.api.ionic.util.messages.exceptions.city;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageCity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.city}")
    private String MESSAGE_ERROR_FIND_ONE_CITY ;

    @Value(value = "${message.error.save.city}")
    private String MESSAGE_ERROR_SAVE_CITY ;

    @Value(value = "${message.error.remove.city}")
    private String MESSAGE_ERROR_REMOVE_CITY ;

    @Value(value = "${message.error.update.city}")
    private String MESSAGE_ERROR_UPDATE_CITY ;

    @Value(value = "${message.error.findAll.city}")
    private String MESSAGE_ERROR_FIND_ALL_CITY ;

    public String getMessageErrorFindOneCity() {
        return MESSAGE_ERROR_FIND_ONE_CITY;
    }

    public String getMessageErrorSaveCity() {
        return MESSAGE_ERROR_SAVE_CITY;
    }

    public String getMessageErrorRemoveCity() {
        return MESSAGE_ERROR_REMOVE_CITY;
    }

    public String getMessageErrorUpdateCity() {
        return MESSAGE_ERROR_UPDATE_CITY;
    }

    public String getMessageErrorFindAllCity() {
        return MESSAGE_ERROR_FIND_ALL_CITY;
    }

}

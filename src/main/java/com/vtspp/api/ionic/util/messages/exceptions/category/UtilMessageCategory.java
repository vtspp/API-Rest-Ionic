package com.vtspp.api.ionic.util.messages.exceptions.category;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.category}")
    private String MESSAGE_ERROR_FIND_ONE_CATEGORY ;

    @Value(value = "${message.error.save.category}")
    private String MESSAGE_ERROR_SAVE_CATEGORY ;

    @Value(value = "${message.error.remove.category}")
    private String MESSAGE_ERROR_REMOVE_CATEGORY ;

    @Value(value = "${message.error.update.category}")
    private String MESSAGE_ERROR_UPDATE_CATEGORY ;

    @Value(value = "${message.error.findAll.category}")
    private String MESSAGE_ERROR_FIND_ALL_CATEGORY ;

    public String getMessageErrorFindOneCategory() {
        return MESSAGE_ERROR_FIND_ONE_CATEGORY;
    }

    public String getMessageErrorSaveCategory() {
        return MESSAGE_ERROR_SAVE_CATEGORY;
    }

    public String getMessageErrorRemoveCategory() {
        return MESSAGE_ERROR_REMOVE_CATEGORY;
    }

    public String getMessageErrorUpdateCategory() {
        return MESSAGE_ERROR_UPDATE_CATEGORY;
    }

    public String getMessageErrorFindAllCategory() {
        return MESSAGE_ERROR_FIND_ALL_CATEGORY;
    }

}

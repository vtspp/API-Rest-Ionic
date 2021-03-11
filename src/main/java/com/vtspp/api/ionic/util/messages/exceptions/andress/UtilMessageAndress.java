package com.vtspp.api.ionic.util.messages.exceptions.andress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageAndress implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.andress}")
    private String MESSAGE_ERROR_FIND_ONE_ANDRESS ;

    @Value(value = "${message.error.save.andress}")
    private String MESSAGE_ERROR_SAVE_ANDRESS ;

    @Value(value = "${message.error.remove.andress}")
    private String MESSAGE_ERROR_REMOVE_ANDRESS ;

    @Value(value = "${message.error.update.andress}")
    private String MESSAGE_ERROR_UPDATE_ANDRESS ;

    @Value(value = "${message.error.findAll.andress}")
    private String MESSAGE_ERROR_FIND_ALL_ANDRESS;

    public  String getMessageErrorFindOneAndress() {
        return MESSAGE_ERROR_FIND_ONE_ANDRESS;
    }

    public String getMessageErrorSaveAndress() {
        return MESSAGE_ERROR_SAVE_ANDRESS;
    }

    public String getMessageErrorRemoveAndress() {
        return MESSAGE_ERROR_REMOVE_ANDRESS;
    }

    public String getMessageErrorUpdateAndress() {
        return MESSAGE_ERROR_UPDATE_ANDRESS;
    }

    public String getMessageErrorFindAllAndress() {
        return MESSAGE_ERROR_FIND_ALL_ANDRESS;
    }

}

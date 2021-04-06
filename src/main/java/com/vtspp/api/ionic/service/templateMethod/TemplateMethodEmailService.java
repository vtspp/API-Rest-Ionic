package com.vtspp.api.ionic.service.templateMethod;

import com.vtspp.api.ionic.service.strategy.EmailService;
import org.springframework.mail.SimpleMailMessage;

public  interface TemplateMethodEmailService<T> extends EmailService<T> {

    @Override
     default void senderConfirmation(T obj) {
        SimpleMailMessage simpleMailMessage = prepareSimpleMailMessage(obj);
        senderEmail(simpleMailMessage);
    }

     SimpleMailMessage prepareSimpleMailMessage(T obj);
}

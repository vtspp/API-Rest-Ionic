package com.vtspp.api.ionic.service.strategy;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService<T> {

    void senderConfirmation(T obj);

    void senderEmail(SimpleMailMessage message);
}

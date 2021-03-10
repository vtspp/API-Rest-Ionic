package com.vtspp.api.ionic.resource.exception.handler;

import com.vtspp.api.ionic.resource.exception.StructureMessageHandler;
import com.vtspp.api.ionic.service.exceptions.telephone.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;

@ControllerAdvice
public class TelephoneResourceHandlerException implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(TelephoneNotFoundException.class)
    protected ResponseEntity<StructureMessageHandler> telephoneNotFoundExceptionHandler (TelephoneNotFoundException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler =  new StructureMessageHandler(HttpStatus.NOT_FOUND.value(),
                                                                                                            e.getMessage(),
                                                                                                            System.currentTimeMillis(),
                                                                                                             LocalDateTime.now(),
                                                                                                             request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageHandler);
    }

    @ExceptionHandler(TelephoneNotSaveException.class)
    protected ResponseEntity<StructureMessageHandler> telephoneNotSaveExceptionHandler (TelephoneNotSaveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INSUFFICIENT_STORAGE.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now(),
                                                                                                            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(messageHandler);
    }

    @ExceptionHandler(TelephoneRemoveException.class)
    protected ResponseEntity<StructureMessageHandler> telephoneRemoveExceptionHandler (TelephoneRemoveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now(),
                                                                                                           request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(TelephoneUpdateException.class)
    protected ResponseEntity<StructureMessageHandler> telephoneUpdateExceptionHandler (TelephoneUpdateException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now(),
                                                                                                            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(TelephoneFindAllException.class)
    protected ResponseEntity<StructureMessageHandler> telephoneFindAllExceptionHandler (TelephoneFindAllException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now(),
                                                                                                           request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }
}

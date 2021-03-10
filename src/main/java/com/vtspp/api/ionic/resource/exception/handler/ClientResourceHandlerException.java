package com.vtspp.api.ionic.resource.exception.handler;

import com.vtspp.api.ionic.resource.exception.StructureMessageHandler;
import com.vtspp.api.ionic.service.exceptions.client.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;

@ControllerAdvice
public class ClientResourceHandlerException implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ClientNotFoundException.class)
    protected ResponseEntity<StructureMessageHandler> clientNotFoundExceptionHandler (ClientNotFoundException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler =  new StructureMessageHandler(HttpStatus.NOT_FOUND.value(),
                                                                                                            e.getMessage(),
                                                                                                            System.currentTimeMillis(),
                                                                                                             LocalDateTime.now(),
                                                                                                             request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageHandler);
    }

    @ExceptionHandler(ClientNotSaveException.class)
    protected ResponseEntity<StructureMessageHandler> clientNotSaveExceptionHandler (ClientNotSaveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INSUFFICIENT_STORAGE.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now(),
                                                                                                            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(messageHandler);
    }

    @ExceptionHandler(ClientRemoveException.class)
    protected ResponseEntity<StructureMessageHandler> clientRemoveExceptionHandler (ClientRemoveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now(),
                                                                                                           request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(ClientUpdateException.class)
    protected ResponseEntity<StructureMessageHandler> clientUpdateExceptionHandler (ClientUpdateException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now(),
                                                                                                            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(ClientFindAllException.class)
    protected ResponseEntity<StructureMessageHandler> clientFindAllExceptionHandler (ClientFindAllException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now(),
                                                                                                           request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }
}

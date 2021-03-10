package com.vtspp.api.ionic.resource.exception.handler;

import com.vtspp.api.ionic.resource.exception.StructureMessageHandler;
import com.vtspp.api.ionic.service.exceptions.andress.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;

@ControllerAdvice
public class AndressResourceHandlerException implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(AndressNotFoundException.class)
    protected ResponseEntity<StructureMessageHandler> andressNotFoundExceptionHandler (AndressNotFoundException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler =  new StructureMessageHandler(HttpStatus.NOT_FOUND.value(),
                                                                                                            e.getMessage(),
                                                                                                            System.currentTimeMillis(),
                                                                                                             LocalDateTime.now(),
                                                                                                             request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageHandler);
    }

    @ExceptionHandler(AndressNotSaveException.class)
    protected ResponseEntity<StructureMessageHandler> andressNotSaveExceptionHandler (AndressNotSaveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INSUFFICIENT_STORAGE.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now(),
                                                                                                            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(messageHandler);
    }

    @ExceptionHandler(AndressRemoveException.class)
    protected ResponseEntity<StructureMessageHandler> andressRemoveExceptionHandler (AndressRemoveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now(),
                                                                                                           request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(AndressUpdateException.class)
    protected ResponseEntity<StructureMessageHandler> andressUpdateExceptionHandler (AndressUpdateException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now(),
                                                                                                            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(AndressFindAllException.class)
    protected ResponseEntity<StructureMessageHandler> andressFindAllExceptionHandler (AndressFindAllException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now(),
                                                                                                           request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }
}

package com.vtspp.api.ionic.resource.handler;

import com.vtspp.api.ionic.service.exceptions.product.*;
import com.vtspp.api.ionic.util.UtilMessageHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;

@ControllerAdvice
public class OrderResourceHandlerException implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ProductNotFoundException.class)
    protected ResponseEntity<UtilMessageHandler> productNotFoundExceptionHandler (ProductNotFoundException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler =  new UtilMessageHandler(HttpStatus.NOT_FOUND.value(),
                                                                                                            e.getMessage(),
                                                                                                            System.currentTimeMillis(),
                                                                                                             LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageHandler);
    }

    @ExceptionHandler(ProductNotSaveException.class)
    protected ResponseEntity<UtilMessageHandler> productNotSaveExceptionHandler (ProductNotSaveException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler = new UtilMessageHandler(HttpStatus.INSUFFICIENT_STORAGE.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(messageHandler);
    }

    @ExceptionHandler(ProductRemoveException.class)
    protected ResponseEntity<UtilMessageHandler> productRemoveExceptionHandler (ProductRemoveException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler = new UtilMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(ProductUpdateException.class)
    protected ResponseEntity<UtilMessageHandler> productUpdateExceptionHandler (ProductUpdateException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler = new UtilMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(ProductFindAllException.class)
    protected ResponseEntity<UtilMessageHandler> productFindAllExceptionHandler (ProductFindAllException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler = new UtilMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }
}

package com.vtspp.api.ionic.resource.handler;

import com.vtspp.api.ionic.service.exceptions.category.*;
import com.vtspp.api.ionic.util.UtilMessageHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;

@ControllerAdvice
public class CategoryResourceHandlerException implements Serializable {

    @ExceptionHandler(CategoryNotFoundException.class)
    protected ResponseEntity<UtilMessageHandler> productNotFoundExceptionHandler (CategoryNotFoundException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler =  new UtilMessageHandler(HttpStatus.NOT_FOUND.value(),
                                                                                                             e.getMessage(),
                                                                                                             System.currentTimeMillis(),
                                                                                                             LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageHandler);
    }

    @ExceptionHandler(CategoryNotSaveException.class)
    protected ResponseEntity<UtilMessageHandler> productNotSaveExceptionHandler (CategoryNotSaveException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler = new UtilMessageHandler(HttpStatus.INSUFFICIENT_STORAGE.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(messageHandler);
    }

    @ExceptionHandler(CategoryRemoveException.class)
    protected ResponseEntity<UtilMessageHandler> productRemoveExceptionHandler (CategoryRemoveException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler = new UtilMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(CategoryUpdateException.class)
    protected ResponseEntity<UtilMessageHandler> productUpdateExceptionHandler (CategoryUpdateException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler = new UtilMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(CategoryFindAllException.class)
    protected ResponseEntity<UtilMessageHandler> productFindAllExceptionHandler (CategoryFindAllException e, HttpServletRequest request) {
        UtilMessageHandler messageHandler = new UtilMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }
}

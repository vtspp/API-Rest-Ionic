package com.vtspp.api.ionic.resource.exception.handler;

import com.vtspp.api.ionic.resource.exception.StructureMessageHandler;
import com.vtspp.api.ionic.service.exceptions.product.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;

@ControllerAdvice
public class CityResourceHandlerException implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ProductNotFoundException.class)
    protected ResponseEntity<StructureMessageHandler> productNotFoundExceptionHandler (ProductNotFoundException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler =  new StructureMessageHandler(HttpStatus.NOT_FOUND.value(),
                                                                                                            e.getMessage(),
                                                                                                            System.currentTimeMillis(),
                                                                                                             LocalDateTime.now(),
                                                                                                             request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageHandler);
    }

    @ExceptionHandler(ProductNotSaveException.class)
    protected ResponseEntity<StructureMessageHandler> productNotSaveExceptionHandler (ProductNotSaveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INSUFFICIENT_STORAGE.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now(),
                                                                                                            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(messageHandler);
    }

    @ExceptionHandler(ProductRemoveException.class)
    protected ResponseEntity<StructureMessageHandler> productRemoveExceptionHandler (ProductRemoveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now(),
                                                                                                           request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(ProductUpdateException.class)
    protected ResponseEntity<StructureMessageHandler> productUpdateExceptionHandler (ProductUpdateException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                            LocalDateTime.now(),
                                                                                                            request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(ProductFindAllException.class)
    protected ResponseEntity<StructureMessageHandler> productFindAllExceptionHandler (ProductFindAllException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                                                           e.getMessage(),
                                                                                                           System.currentTimeMillis(),
                                                                                                           LocalDateTime.now(),
                                                                                                           request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }
}

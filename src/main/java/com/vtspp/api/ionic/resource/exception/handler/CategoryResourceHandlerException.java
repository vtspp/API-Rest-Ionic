package com.vtspp.api.ionic.resource.exception.handler;

import com.vtspp.api.ionic.resource.exception.StructureMessageHandler;
import com.vtspp.api.ionic.service.exceptions.category.*;
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
    protected ResponseEntity<StructureMessageHandler> categoryNotFoundExceptionHandler (CategoryNotFoundException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler =  new StructureMessageHandler(HttpStatus.NOT_FOUND.value(),
                                                                                                             e.getMessage(),
                                                                                                             System.currentTimeMillis(),
                                                                                                             LocalDateTime.now(),
                                                                                                             request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageHandler);
    }

    @ExceptionHandler(CategoryNotSaveException.class)
    protected ResponseEntity<StructureMessageHandler> categoryNotSaveExceptionHandler (CategoryNotSaveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INSUFFICIENT_STORAGE.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                LocalDateTime.now(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(messageHandler);
    }

    @ExceptionHandler(CategoryRemoveException.class)
    protected ResponseEntity<StructureMessageHandler> categoryRemoveExceptionHandler (CategoryRemoveException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                LocalDateTime.now(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(CategoryUpdateException.class)
    protected ResponseEntity<StructureMessageHandler> categoryUpdateExceptionHandler (CategoryUpdateException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                LocalDateTime.now(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }

    @ExceptionHandler(CategoryFindAllException.class)
    protected ResponseEntity<StructureMessageHandler> categoryFindAllExceptionHandler (CategoryFindAllException e, HttpServletRequest request) {
        StructureMessageHandler messageHandler = new StructureMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                LocalDateTime.now(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageHandler);
    }
}

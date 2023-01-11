package com.demo.currancyconverter.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.AllArgsConstructor;

@ControllerAdvice
@AllArgsConstructor
public class BaseExceptionHandler {
	
    
    MessageSource messageSource;

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<Object> handleCurrencyNotFoundException(
            CurrencyNotFoundException ex, WebRequest request) {
    	String msg = messageSource.getMessage(ex.getMessage(), null, request.getLocale());
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
}

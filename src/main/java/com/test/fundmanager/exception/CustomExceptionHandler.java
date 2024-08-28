package com.test.fundmanager.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ MinimumAmountValidationException.class })
    public ResponseEntity<Object> handlePaymentException(Exception ex, WebRequest request) {
    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
package com.discovery.bank;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.discovery.bank.exception.AccountNotFoundException;
import com.discovery.bank.exception.AtmNotFoundException;
import com.discovery.bank.exception.InsufficentFundsException;
import com.discovery.bank.exception.RemainderException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler({ AccountNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "No accounts to display!", 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    
    @ExceptionHandler({ AtmNotFoundException.class })
    protected ResponseEntity<Object> handleAtmNotFound(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "ATM not registered or unfunded", 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    
    @ExceptionHandler({ InsufficentFundsException.class })
    protected ResponseEntity<Object> handleInsufficientFunds(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Insufficient funds. "+(ex.getMessage() != null ? ex.getMessage():""), 
          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    
    @ExceptionHandler({ RemainderException.class })
    protected ResponseEntity<Object> handleRemainder(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Amount not available, would you like to draw "+ex.getMessage()+"?", 
          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    
    
}
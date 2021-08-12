package com.example.demo.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMassage> somethingWentWrong(Exception ex, WebRequest request) {
        ErrorMassage exceptionResponse = new ErrorMassage(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorMassage> userNotFound(UserNotFoundException ex, WebRequest request){
        ErrorMassage exceptionResponse = new ErrorMassage(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}

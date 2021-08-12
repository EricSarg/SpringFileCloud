package com.example.demo.handler;

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
    public final ResponseEntity<ErrorMassage> somethingWentWrong(Exception ex, WebRequest request){
        ErrorMassage exceptionResponse = new ErrorMassage(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity <ErrorMassage> (exceptionResponse,
                new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public static class ErrorMassage{
        private String massage;
        private HttpStatus status;

        public ErrorMassage(String massage, HttpStatus status) {
            this.massage = massage;
            this.status = status;
        }

        public String getMassage() {
            return massage;
        }

        public void setMassage(String massage) {
            this.massage = massage;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public void setStatus(HttpStatus status) {
            this.status = status;
        }
    }

}

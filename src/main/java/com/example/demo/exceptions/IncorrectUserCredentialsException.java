package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(value = HttpStatus.CONFLICT)
public class IncorrectUserCredentialsException extends Exception {
    public IncorrectUserCredentialsException() {
        super("Username or password is incorrect");
    }
}

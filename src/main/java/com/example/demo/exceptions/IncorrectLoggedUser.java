package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(value = HttpStatus.CONFLICT,reason = "incorrect login or password:")
public class IncorrectLoggedUser extends Exception {
    public IncorrectLoggedUser(String incorrect_userName_or_password) {
        super(incorrect_userName_or_password);
    }
}

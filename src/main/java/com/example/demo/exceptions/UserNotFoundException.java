package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
    public UserNotFoundException(@NonNull Long id) {
        super("There is no user with id: " + id);
    }
}

package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Confirm password must be the same with password:")
public class PasswordsNotMatching extends Exception {

    public PasswordsNotMatching(String s) {
        super(s);
    }

}

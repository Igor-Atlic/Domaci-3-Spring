package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(String message) {
        super(message);
    }

}

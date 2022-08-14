package com.example.demo.controllers;

public class UserDoesntExistException extends RuntimeException{

    public UserDoesntExistException(String message){
        super(message);
    }
}

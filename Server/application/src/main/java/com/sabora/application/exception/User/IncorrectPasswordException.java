package com.sabora.application.exception.User;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException() {
        super("Incorrect password introduced.");
    }
}

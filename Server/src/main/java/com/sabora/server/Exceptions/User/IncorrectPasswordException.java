package com.sabora.server.Exceptions.User;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException() {
        super("Incorrect password introduced.");
    }
}

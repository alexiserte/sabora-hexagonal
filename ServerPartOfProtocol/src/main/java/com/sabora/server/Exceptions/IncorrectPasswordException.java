package com.sabora.server.Exceptions;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException() {
        super("Incorrect password introduced.");
    }
}

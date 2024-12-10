package com.sabora.server.Exceptions;

public class AlreadyExistingUserException extends RuntimeException{
    public AlreadyExistingUserException(String username) {
        super("User with username: " + username + " already exists.");
    }
}

package com.sabora.application.exception.User;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userName) {
        super(String.format("The user @%s was not found", userName));
    }
}

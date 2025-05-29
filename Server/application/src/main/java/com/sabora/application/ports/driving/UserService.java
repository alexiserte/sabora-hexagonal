package com.sabora.application.ports.driving;

public interface UserService<T> {

    void registerUser(T user);
    T getUser(String username);
}

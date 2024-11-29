package com.sabora.server.Services;

public interface UserService<T> {

    void registerUser(T user);
    T getUser(String username);
}

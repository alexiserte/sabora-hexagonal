package com.sabora.application.Encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncrypter {
    private final PasswordEncoder passwordEncoder;

    public PasswordEncrypter() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean checkPassword(String password, String encodedPassword) {
        if (passwordEncoder.matches(password, encodedPassword)) return true;
        else throw new IllegalArgumentException("The given password does not match the encoded password.");
    }

}

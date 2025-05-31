package com.sabora.application.validation;

import com.sabora.application.domain.User;
import com.sabora.application.exception.User.UserValidationException;

public class UserValidation {

    private static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String dniRegex = "^[0-9]{8}[A-Z]$";
    private static final String phoneRegex = "^[0-9]{9}$";

    private static boolean isValidEmail(String email) {
       if (!email.matches(emailRegex)) throw new UserValidationException("The given email is not valid. Please provide a valid email (x@y.z)");
       return true;
    }

    private static boolean isValidDNI(String dni) {
        if (!dni.matches(dniRegex)) throw new UserValidationException("The given DNI is not valid. Please provide a valid DNI (8 digits followed by a letter)");
        return true;
    }

    private static boolean isValidPhone(String phone) {
        if (!phone.matches(phoneRegex)) throw new UserValidationException("The given phone number is not valid. Please provide a valid phone number (9 digits)");
        return true;
    }


    public static boolean validateUser(User user){
        return isValidEmail(user.getEmail()) && isValidDNI(user.getDni()) && isValidPhone(String.valueOf(user.getTelefono()));
    }
}

package com.example.finalProject.Security;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class UserValidation {
    public boolean emailValidation(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    public boolean mobileValidation(String mobile) {
        String regexPattern = "^\\d{11}$";
        return Pattern.compile(regexPattern)
                .matcher(mobile)
                .matches();
    }
}

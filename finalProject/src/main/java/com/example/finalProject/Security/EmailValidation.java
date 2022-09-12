package com.example.finalProject.Security;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class EmailValidation implements Predicate<String> {
@Override
    public boolean test(String s){
    //TODO:REGAX TO VALIDATE EMAIL
    return true;
}
}

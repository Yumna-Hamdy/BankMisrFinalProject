package com.example.finalProject.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class RegisteredDetails {
    public String access_token;
    public String username;
    public String email;
    public String mobile;
    public Long user_id;
    public int expire;

}

package com.example.finalProject.Services;

import com.example.finalProject.Entities.User;
import com.example.finalProject.Repositories.UserRepository;
import com.example.finalProject.Security.EmailValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private EmailValidation emailValidation;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        //return UserRepository.findByUserName(username);
    }

    public String register(User user) {
        boolean isValid = emailValidation.test(user.getEmail());
        boolean userExists =userRepository.findByEmail(user.getEmail()).isPresent();
        if (!isValid || userExists){
            throw new IllegalStateException("email not valid");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        //TODO return token
        return "works";
    }
}

package com.example.finalProject.Services;

import com.example.finalProject.Entities.User;
import com.example.finalProject.Repositories.UserRepository;
import com.example.finalProject.Security.UserValidation;
import com.example.finalProject.Token.ConfirmationToken;
import com.example.finalProject.Token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private UserValidation userValidation;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public User register(User user) {
        boolean isEmailValid = userValidation.emailValidation(user.getEmail());
        boolean isMobileValid = userValidation.mobileValidation(user.getMobile());
        boolean userExists =userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"user with same email already exist");
        } else if (!isEmailValid) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"E-mail not valid");
        }else if (!isMobileValid) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Mobile not valid");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return user;
    }
    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userRepository.enableAppUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).get();
    }
}

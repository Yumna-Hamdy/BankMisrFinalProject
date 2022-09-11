package com.example.finalProject.Controllers;

import com.example.finalProject.Entities.User;
import com.example.finalProject.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path= "/")
public class UserController {

//    @Autowired
//    private JwtUtil jwtUtil;
//    @Autowired
//    private AuthenticationManager authenticationManager;
    private final UserService userService;

    @GetMapping
    public String welcome() {
        return "Welcome to javatechie !!";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.register(user);
    }


//    @PostMapping("/authenticate")
//    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
//            );
//        } catch (Exception ex) {
//            throw new Exception("inavalid username/password");
//        }
//        return jwtUtil.generateToken(authRequest.getUserName());
//    }


}

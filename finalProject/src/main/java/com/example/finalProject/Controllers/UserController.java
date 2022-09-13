package com.example.finalProject.Controllers;

import com.example.finalProject.Entities.User;
import com.example.finalProject.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor @CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path= "/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok().body(userService.register(user));
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return userService.confirmToken(token);
    }

    @GetMapping(path = "/test")
    public String test(){
        return "h3l";
    }



}

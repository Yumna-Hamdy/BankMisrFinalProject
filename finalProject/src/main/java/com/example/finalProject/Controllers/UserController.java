package com.example.finalProject.Controllers;

import com.example.finalProject.Entities.User;
import com.example.finalProject.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path= "/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        //URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/register").toUriString());
        return ResponseEntity.ok().body(userService.register(user));
    }
    @GetMapping(path = "confirm")
    public ResponseEntity<String> confirm(@RequestParam("token") String token) {
        return ResponseEntity.ok().body(userService.confirmToken(token));
    }
    @GetMapping(path = "/test")
    public String test(){
        return "h3l";
    }



}

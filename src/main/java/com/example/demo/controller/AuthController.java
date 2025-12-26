
package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User savedUser = userService.login(user.getEmail(), user.getPassword());
        String token = jwtTokenProvider.generateToken(savedUser);
        return token;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User savedUser = userService.register(user);
        String token = jwtTokenProvider.generateToken(savedUser);
        return token;
    }
}

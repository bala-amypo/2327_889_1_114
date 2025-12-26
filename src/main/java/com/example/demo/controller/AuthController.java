
package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User newUser = userService.register(user);
        // Generate JWT token using username (not User object)
        String token = jwtTokenProvider.generateToken(newUser.getUsername());
        return ResponseEntity.ok(token);
    }

    // Login existing user
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User existingUser = userService.authenticate(user.getUsername(), user.getPassword());
        if (existingUser == null) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        // Generate JWT token using username (not User object)
        String token = jwtTokenProvider.generateToken(existingUser.getUsername());
        return ResponseEntity.ok(token);
    }
}

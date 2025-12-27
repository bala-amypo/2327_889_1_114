// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @PostMapping("/register")
//     public String register() {
//         return "ok";
//     }

//     @PostMapping("/login")
//     public String login() {
//         return "ok";
//     }
// }
package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "APIs for user authentication")
public class AuthController {
    
    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/register")
    @Operation(summary = "Register user", description = "Register a new user")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User created = userService.register(user);
            return ResponseEntity.ok(Map.of("message", "User registered successfully", "userId", created.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login user", description = "Authenticate user and return JWT token")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String email = loginRequest.get("email");
            String password = loginRequest.get("password");
            
            User user = userService.findByEmail(email);
            if (passwordEncoder.matches(password, user.getPassword())) {
                String token = jwtTokenProvider.generateToken(user.getId(), user.getEmail(), user.getRole());
                return ResponseEntity.ok(Map.of(
                    "token", token,
                    "userId", user.getId(),
                    "email", user.getEmail(),
                    "role", user.getRole()
                ));
            } else {
                return ResponseEntity.badRequest().body(Map.of("error", "Invalid credentials"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid credentials"));
        }
    }
}
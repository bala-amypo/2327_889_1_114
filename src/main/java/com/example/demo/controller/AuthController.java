package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserServiceImpl userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    
    public AuthController(UserServiceImpl userService, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User created = userService.register(user);
        return ResponseEntity.ok(created);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtTokenProvider.generateToken(user.getId(), user.getEmail(), user.getRole());
            return ResponseEntity.ok(new LoginResponse(token, user.getId(), user.getEmail(), user.getRole()));
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }
    
    public static class LoginRequest {
        private String email;
        private String password;
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
    
    public static class LoginResponse {
        private String token;
        private Long userId;
        private String email;
        private String role;
        
        public LoginResponse(String token, Long userId, String email, String role) {
            this.token = token;
            this.userId = userId;
            this.email = email;
            this.role = role;
        }
        
        public String getToken() { return token; }
        public Long getUserId() { return userId; }
        public String getEmail() { return email; }
        public String getRole() { return role; }
    }
}
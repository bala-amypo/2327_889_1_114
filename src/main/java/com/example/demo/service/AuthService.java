package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String register(String username, String password, String email) {
        // Implementation
        return "User registered";
    }
    
    public String login(String username, String password) {
        // Implementation
        return "Login successful";
    }
}
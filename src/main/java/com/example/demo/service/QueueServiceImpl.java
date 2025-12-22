package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String extractUsername(String token) {
        return "dummy@email.com"; // dummy for now
    }

    
    public boolean validateToken(String token) {
        return true;
    }

   
    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }
}

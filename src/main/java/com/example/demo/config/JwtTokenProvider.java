package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email) {
        return "dummy-token";
    }
}

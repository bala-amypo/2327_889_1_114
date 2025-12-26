
package com.example.demo.controller;

import com.example.demo.entity.Token;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/create")
    public Token createToken(@RequestBody Token token) {
        return tokenService.createToken(token);
    }

    @GetMapping("/all")
    public List<Token> getAllTokens() {
        return tokenService.getAllTokens();
    }
}

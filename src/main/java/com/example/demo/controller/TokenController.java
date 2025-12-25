package com.example.demo.controller;

import com.example.demo.entity.Token;
import com.example.demo.service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    private final TokenService service;

    public TokenController(TokenService s) {
        this.service = s;
    }

    @PostMapping("/issue/{counterId}")
    public Token issue(@PathVariable Long counterId) {
        return service.issueToken(counterId);
    }

    @PutMapping("/{id}/{status}")
    public Token update(@PathVariable Long id, @PathVariable String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/{id}")
    public Token get(@PathVariable Long id) {
        return service.getToken(id);
    }
}

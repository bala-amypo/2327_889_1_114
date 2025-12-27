package com.example.demo.controller;

import com.example.demo.entity.Token;
import com.example.demo.service.impl.TokenServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {
    private final TokenServiceImpl tokenService;
    
    public TokenController(TokenServiceImpl tokenService) {
        this.tokenService = tokenService;
    }
    
    @PostMapping("/counter/{counterId}")
    public ResponseEntity<Token> issueToken(@PathVariable Long counterId) {
        Token token = tokenService.issueToken(counterId);
        return ResponseEntity.ok(token);
    }
    
    @PutMapping("/{tokenId}/status")
    public ResponseEntity<Token> updateStatus(@PathVariable Long tokenId, @RequestParam String status) {
        Token token = tokenService.updateStatus(tokenId, status);
        return ResponseEntity.ok(token);
    }
    
    @GetMapping("/{tokenId}")
    public ResponseEntity<Token> getToken(@PathVariable Long tokenId) {
        Token token = tokenService.getToken(tokenId);
        return ResponseEntity.ok(token);
    }
}
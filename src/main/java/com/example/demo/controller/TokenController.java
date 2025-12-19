// src/main/java/com/example/demo/controller/TokenController.java
package com.example.demo.controller;

import com.example.demo.entity.Token;
import com.example.demo.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @PostMapping("/issue/{counterId}")
    public ResponseEntity<Token> issueToken(@PathVariable Long counterId) {
        Token token = tokenService.issueToken(counterId);
        return ResponseEntity.ok(token);
    }

    @PutMapping("/status/{tokenId}")
    public ResponseEntity<Token> updateStatus(
            @PathVariable Long tokenId,
            @RequestParam String status) {
        Token updatedToken = tokenService.updateStatus(tokenId, status);
        return ResponseEntity.ok(updatedToken);
    }

    @GetMapping("/{tokenId}")
    public ResponseEntity<Token> getToken(@PathVariable Long tokenId) {
        Token token = tokenService.getToken(tokenId);
        return ResponseEntity.ok(token);
    }
}
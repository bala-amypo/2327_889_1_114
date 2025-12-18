package com.example.controller;

import com.example.model.Token;
import com.example.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tokens")
public class TokenController {
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/issue/{counterId}")
    public ResponseEntity<?> issueToken(@PathVariable Long counterId) {
        try {
            Token token = tokenService.issueToken(counterId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Token issued successfully");
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    @PutMapping("/status/{tokenId}")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long tokenId,
            @RequestBody Map<String, String> statusRequest) {
        try {
            String status = statusRequest.get("status");
            Token updatedToken = tokenService.updateStatus(tokenId, status);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Token status updated successfully");
            response.put("token", updatedToken);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    @GetMapping("/{tokenId}")
    public ResponseEntity<?> getToken(@PathVariable Long tokenId) {
        try {
            Token token = tokenService.getToken(tokenId)
                .orElseThrow(() -> new RuntimeException("Token not found"));
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }
}
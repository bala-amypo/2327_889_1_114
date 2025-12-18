package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.service.AuthService;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;

@RestController
@RequestMapping("/logs")
@Tag(name = "Token Log Controller")
public class TokenLogController {

    private final TokenLogService tokenLogService;

    public TokenLogController(TokenLogService tokenLogService) {
        this.tokenLogService = tokenLogService;
    }

    @PostMapping("/{tokenId}")
    @Operation(summary = "Add log for token")
    public ResponseEntity<?> addLog(
            @PathVariable Long tokenId,
            @RequestParam String message) {
        return ResponseEntity.ok(tokenLogService.addLog(tokenId, message));
    }

    @GetMapping("/{tokenId}")
    @Operation(summary = "Get logs for token")
    public ResponseEntity<?> getLogs(@PathVariable Long tokenId) {
        return ResponseEntity.ok(tokenLogService.getLogs(tokenId));
    }
}
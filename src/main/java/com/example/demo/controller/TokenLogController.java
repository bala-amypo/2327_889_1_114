// src/main/java/com/example/demo/controller/TokenLogController.java
package com.example.demo.controller;

import com.example.demo.entity.TokenLog;
import com.example.demo.service.TokenLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class TokenLogController {
    private final TokenLogService tokenLogService;

    @PostMapping("/{tokenId}")
    public ResponseEntity<TokenLog> addLog(
            @PathVariable Long tokenId,
            @RequestParam String message) {
        TokenLog log = tokenLogService.addLog(tokenId, message);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/{tokenId}")
    public ResponseEntity<List<TokenLog>> getLogs(@PathVariable Long tokenId) {
        List<TokenLog> logs = tokenLogService.getLogs(tokenId);
        return ResponseEntity.ok(logs);
    }
}
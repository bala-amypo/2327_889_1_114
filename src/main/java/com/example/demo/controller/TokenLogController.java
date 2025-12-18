package com.example.controller;

import com.example.model.TokenLog;
import com.example.service.TokenLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logs")
public class TokenLogController {
    
    @Autowired
    private TokenLogService tokenLogService;
    
    @PostMapping("/{tokenId}")
    public ResponseEntity<?> addLog(
            @PathVariable Long tokenId,
            @RequestBody Map<String, String> logRequest) {
        try {
            String message = logRequest.get("message");
            TokenLog log = tokenLogService.addLog(tokenId, message);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Log added successfully");
            response.put("log", log);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    @GetMapping("/{tokenId}")
    public ResponseEntity<?> getLogs(@PathVariable Long tokenId) {
        try {
            List<TokenLog> logs = tokenLogService.getLogs(tokenId);
            return ResponseEntity.ok(logs);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
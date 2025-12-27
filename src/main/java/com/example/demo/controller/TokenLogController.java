// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/logs")
// public class TokenLogController {

//     @PostMapping("/{tokenId}")
//     public String addLog() {
//         return "ok";
//     }

//     @GetMapping("/{tokenId}")
//     public String getLogs() {
//         return "ok";
//     }
// }
package com.example.demo.controller;

import com.example.demo.service.impl.TokenLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Token Log Management", description = "APIs for managing token logs")
public class TokenLogController {
    
    @Autowired
    private TokenLogServiceImpl logService;
    
    @PostMapping("/{tokenId}")
    @Operation(summary = "Add log entry", description = "Add a log entry for a token")
    public ResponseEntity<?> addLog(@PathVariable Long tokenId, @RequestBody Map<String, String> request) {
        try {
            String message = request.get("message");
            return ResponseEntity.ok(logService.addLog(tokenId, message));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{tokenId}")
    @Operation(summary = "Get token logs", description = "Get all logs for a specific token")
    public ResponseEntity<?> getLogs(@PathVariable Long tokenId) {
        return ResponseEntity.ok(logService.getLogs(tokenId));
    }
}
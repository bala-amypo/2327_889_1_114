// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/counters")
// public class ServiceCounterController {

//     @PostMapping
//     public String addCounter() {
//         return "ok";
//     }

//     @GetMapping("/active")
//     public String getActive() {
//         return "ok";
//     }
// }
package com.example.demo.controller;

import com.example.demo.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tokens")
@Tag(name = "Token Management", description = "APIs for managing tokens and queue")
public class TokenController {
    
    @Autowired
    private TokenServiceImpl tokenService;
    
    @PostMapping("/issue/{counterId}")
    @Operation(summary = "Issue new token", description = "Issue a new token for the specified counter")
    public ResponseEntity<?> issueToken(@PathVariable Long counterId) {
        try {
            return ResponseEntity.ok(tokenService.issueToken(counterId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{tokenId}/status")
    @Operation(summary = "Update token status", description = "Update the status of a token")
    public ResponseEntity<?> updateStatus(@PathVariable Long tokenId, @RequestParam String status) {
        try {
            return ResponseEntity.ok(tokenService.updateStatus(tokenId, status));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{tokenId}")
    @Operation(summary = "Get token details", description = "Get details of a specific token")
    public ResponseEntity<?> getToken(@PathVariable Long tokenId) {
        try {
            return ResponseEntity.ok(tokenService.getToken(tokenId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
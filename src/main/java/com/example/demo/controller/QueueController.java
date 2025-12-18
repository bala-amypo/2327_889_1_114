package com.example.controller;

import com.example.model.QueuePosition;
import com.example.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/queue")
public class QueueController {
    
    @Autowired
    private QueueService queueService;
    
    @PutMapping("/position/{tokenId}")
    public ResponseEntity<?> updateQueuePosition(
            @PathVariable Long tokenId,
            @RequestBody Map<String, Integer> positionRequest) {
        try {
            Integer newPosition = positionRequest.get("newPosition");
            QueuePosition queuePosition = queueService.updateQueuePosition(tokenId, newPosition);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Queue position updated successfully");
            response.put("queuePosition", queuePosition);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    @GetMapping("/position/{tokenId}")
    public ResponseEntity<?> getPosition(@PathVariable Long tokenId) {
        try {
            QueuePosition position = queueService.getPosition(tokenId)
                .orElseThrow(() -> new RuntimeException("Position not found for token"));
            return ResponseEntity.ok(position);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }
}
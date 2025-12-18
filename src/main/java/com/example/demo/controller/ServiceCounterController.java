package com.example.controller;

import com.example.model.ServiceCounter;
import com.example.service.ServiceCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/counters")
public class ServiceCounterController {
    
    @Autowired
    private ServiceCounterService serviceCounterService;
    
    @PostMapping
    public ResponseEntity<?> addCounter(@RequestBody ServiceCounter counter) {
        try {
            ServiceCounter savedCounter = serviceCounterService.addCounter(counter);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Counter added successfully");
            response.put("counter", savedCounter);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    @GetMapping("/active")
    public ResponseEntity<?> getActiveCounters() {
        try {
            List<ServiceCounter> counters = serviceCounterService.getActiveCounters();
            return ResponseEntity.ok(counters);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
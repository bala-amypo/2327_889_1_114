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
@RequestMapping("/counters")
@Tag(name = "Service Counter Controller")
public class ServiceCounterController {

    private final ServiceCounterService counterService;

    public ServiceCounterController(ServiceCounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping
    @Operation(summary = "Add new service counter")
    public ResponseEntity<?> addCounter(@RequestBody ServiceCounter counter) {
        return ResponseEntity.ok(counterService.addCounter(counter));
    }

    @GetMapping("/active")
    @Operation(summary = "List active counters")
    public ResponseEntity<?> getActiveCounters() {
        return ResponseEntity.ok(counterService.getActiveCounters());
    }
}
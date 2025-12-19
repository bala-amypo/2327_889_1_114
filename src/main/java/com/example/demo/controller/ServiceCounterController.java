// src/main/java/com/example/demo/controller/ServiceCounterController.java
package com.example.demo.controller;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.service.ServiceCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/counter")
@RequiredArgsConstructor
public class ServiceCounterController {
    private final ServiceCounterService serviceCounterService;

    @PostMapping
    public ResponseEntity<ServiceCounter> addCounter(@RequestBody ServiceCounter counter) {
        ServiceCounter savedCounter = serviceCounterService.addCounter(counter);
        return ResponseEntity.ok(savedCounter);
    }

    @GetMapping("/active")
    public ResponseEntity<List<ServiceCounter>> getActiveCounters() {
        List<ServiceCounter> activeCounters = serviceCounterService.getActiveCounters();
        return ResponseEntity.ok(activeCounters);
    }
}
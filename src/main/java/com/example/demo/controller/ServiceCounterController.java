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

import com.example.demo.entity.ServiceCounter;
import com.example.demo.service.impl.ServiceCounterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/counters")
@Tag(name = "Service Counter Management", description = "APIs for managing service counters")
public class ServiceCounterController {
    
    @Autowired
    private ServiceCounterServiceImpl counterService;
    
    @PostMapping
    @Operation(summary = "Add counter", description = "Add a new service counter")
    public ResponseEntity<?> addCounter(@RequestBody ServiceCounter counter) {
        try {
            return ResponseEntity.ok(counterService.addCounter(counter));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/active")
    @Operation(summary = "Get active counters", description = "Get all active service counters")
    public ResponseEntity<?> getActiveCounters() {
        return ResponseEntity.ok(counterService.getActiveCounters());
    }
}
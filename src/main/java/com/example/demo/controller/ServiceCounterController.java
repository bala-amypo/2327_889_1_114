package com.example.demo.controller;

import com.example.demo.dto.ServiceCounterResponse;
import com.example.demo.entity.ServiceCounter;
import com.example.demo.service.ServiceCounterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/counters")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Service Counters", description = "Service counter management endpoints")
public class ServiceCounterController {
    
    private final ServiceCounterService counterService;
    
    public ServiceCounterController(ServiceCounterService counterService) {
        this.counterService = counterService;
    }
    
    @PostMapping
    @Operation(summary = "Add a new service counter")
    public ResponseEntity<ServiceCounterResponse> addCounter(@RequestBody ServiceCounter counter) {
        ServiceCounter created = counterService.createCounter(counter);
        return new ResponseEntity<>(toResponse(created), HttpStatus.CREATED);
    }
    
    @GetMapping
    @Operation(summary = "Get all service counters")
    public ResponseEntity<List<ServiceCounterResponse>> getAllCounters() {
        List<ServiceCounter> counters = counterService.getAllCounters();
        return ResponseEntity.ok(counters.stream().map(this::toResponse).collect(Collectors.toList()));
    }
    
    @GetMapping("/active")
    @Operation(summary = "Get all active service counters")
    public ResponseEntity<List<ServiceCounterResponse>> getActiveCounters() {
        List<ServiceCounter> counters = counterService.getActiveCounters();
        return ResponseEntity.ok(counters.stream().map(this::toResponse).collect(Collectors.toList()));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get service counter by ID")
    public ResponseEntity<ServiceCounterResponse> getCounterById(@PathVariable Long id) {
        ServiceCounter counter = counterService.getCounterById(id);
        return ResponseEntity.ok(toResponse(counter));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update service counter")
    public ResponseEntity<ServiceCounterResponse> updateCounter(@PathVariable Long id, 
                                                                @RequestBody ServiceCounter counter) {
        ServiceCounter updated = counterService.updateCounter(id, counter);
        return ResponseEntity.ok(toResponse(updated));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete service counter")
    public ResponseEntity<Void> deleteCounter(@PathVariable Long id) {
        counterService.deleteCounter(id);
        return ResponseEntity.noContent().build();
    }
    
    private ServiceCounterResponse toResponse(ServiceCounter counter) {
        return new ServiceCounterResponse(
            counter.getId(),
            counter.getName(),
            counter.getIsActive(),
            counter.getDescription()
        );
    }
}
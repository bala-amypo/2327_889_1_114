
package com.example.demo.controller;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.service.ServiceCounterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-counters")
public class ServiceCounterController {

    private final ServiceCounterService serviceCounterService;

    public ServiceCounterController(ServiceCounterService serviceCounterService) {
        this.serviceCounterService = serviceCounterService;
    }

    @PostMapping
    public ServiceCounter createCounter(@RequestBody ServiceCounter counter) {
        return serviceCounterService.create(counter);
    }

    @GetMapping
    public List<ServiceCounter> getAllCounters() {
        return serviceCounterService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceCounter getCounterById(@PathVariable Long id) {
        return serviceCounterService.getById(id);
    }
}


package com.example.demo.controller;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.service.ServiceCounterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-counter")
public class ServiceCounterController {

    private final ServiceCounterService serviceCounterService;

    public ServiceCounterController(ServiceCounterService serviceCounterService) {
        this.serviceCounterService = serviceCounterService;
    }

    @PostMapping("/create")
    public ServiceCounter create(@RequestBody ServiceCounter counter) {
        return serviceCounterService.create(counter);
    }

    @GetMapping("/all")
    public List<ServiceCounter> getAll() {
        return serviceCounterService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceCounter getById(@PathVariable Long id) {
        return serviceCounterService.getById(id);
    }
}

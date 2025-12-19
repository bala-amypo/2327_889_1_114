// src/main/java/com/example/demo/service/ServiceCounterService.java
package com.example.demo.service;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.repository.ServiceCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCounterService {
    private final ServiceCounterRepository serviceCounterRepository;

    public ServiceCounter addCounter(ServiceCounter counter) {
        return serviceCounterRepository.save(counter);
    }

    public List<ServiceCounter> getActiveCounters() {
        return serviceCounterRepository.findByIsActiveTrue();
    }
}
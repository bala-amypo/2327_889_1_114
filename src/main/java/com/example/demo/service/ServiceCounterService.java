package com.example.service;

import com.example.model.ServiceCounter;
import com.example.repository.ServiceCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceCounterService {
    
    @Autowired
    private ServiceCounterRepository serviceCounterRepository;
    
    public ServiceCounter addCounter(ServiceCounter counter) {
        return serviceCounterRepository.save(counter);
    }
    
    public List<ServiceCounter> getActiveCounters() {
        return serviceCounterRepository.findActiveCounters();
    }
}
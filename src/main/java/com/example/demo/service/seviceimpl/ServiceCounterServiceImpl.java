package com.example.demo.service.impl;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ServiceCounterRepository;
import com.example.demo.service.ServiceCounterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceCounterServiceImpl implements ServiceCounterService {
    
    private final ServiceCounterRepository counterRepository;
    
    public ServiceCounterServiceImpl(ServiceCounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }
    
    @Override
    public ServiceCounter addCounter(ServiceCounter counter) {
        if (counter.getIsActive() == null) {
            counter.setIsActive(true);
        }
        return counterRepository.save(counter);
    }
    
    @Override
    public ServiceCounter getCounterById(Long id) {
        return counterRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Service counter not found with id: " + id));
    }
    
    @Override
    public List<ServiceCounter> getAllCounters() {
        return counterRepository.findAll();
    }
    
    @Override
    public List<ServiceCounter> getActiveCounters() {
        return counterRepository.findByIsActiveTrue();
    }
    
    @Override
    public ServiceCounter updateCounter(Long id, ServiceCounter counter) {
        ServiceCounter existing = getCounterById(id);
        
        if (counter.getName() != null) {
            existing.setName(counter.getName());
        }
        
        if (counter.getIsActive() != null) {
            existing.setIsActive(counter.getIsActive());
        }
        
        if (counter.getDescription() != null) {
            existing.setDescription(counter.getDescription());
        }
        
        return counterRepository.save(existing);
    }
    
    @Override
    public void deleteCounter(Long id) {
        ServiceCounter counter = getCounterById(id);
        counterRepository.delete(counter);
    }
}
package com.example.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ServiceCounter;
import com.example.demo.model.repository.ServiceCounterRepository;
import com.example.demo.model.service.ServiceCounterService;

@Service
public class ServiceCounterServiceImpl implements ServiceCounterService {

    private final ServiceCounterRepository counterRepository;

    public ServiceCounterServiceImpl(ServiceCounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public ServiceCounter addCounter(ServiceCounter counter) {
        return counterRepository.save(counter);
    }

    @Override
    public List<ServiceCounter> getActiveCounters() {
        return counterRepository.findByIsActiveTrue();
    }
}

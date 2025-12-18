package com.example.service.impl;

import com.example.model.ServiceCounter;
import com.example.repository.ServiceCounterRepository;
import com.example.service.ServiceCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceCounterServiceImpl implements ServiceCounterService {
    
    @Autowired
    private ServiceCounterRepository serviceCounterRepository;
    
    @Override
    public ServiceCounter addCounter(ServiceCounter counter) {
        if (counter.getIsActive() == null) {
            counter.setIsActive(true);
        }
        return serviceCounterRepository.save(counter);
    }
    
    @Override
    public List<ServiceCounter> getActiveCounters() {
        return serviceCounterRepository.findActiveCounters();
    }
}
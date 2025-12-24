package com.example.demo.service.seviceimpl;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.repository.ServiceCounterRepository;
import com.example.demo.service.ServiceCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCounterServiceImpl implements ServiceCounterService {

    @Autowired
    private ServiceCounterRepository counterRepository;

    public ServiceCounterServiceImpl(ServiceCounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public ServiceCounter createCounter(ServiceCounter counter) {
        if (counterRepository.existsByName(counter.getName())) {
            throw new RuntimeException("Counter with name '" + counter.getName() + "' already exists");
        }
        counter.setIsActive(true);
        return counterRepository.save(counter);
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
    public ServiceCounter getCounterById(Long id) {
        return counterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Counter not found with id: " + id));
    }

    @Override
    public ServiceCounter updateCounter(Long id, ServiceCounter counter) {
        ServiceCounter existing = getCounterById(id);
        
        if (counter.getName() != null && !counter.getName().equals(existing.getName())) {
            if (counterRepository.existsByName(counter.getName())) {
                throw new RuntimeException("Counter with name '" + counter.getName() + "' already exists");
            }
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

package com.example.demo.service.impl;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.repository.ServiceCounterRepository;
import com.example.demo.service.ServiceCounterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCounterServiceImpl implements ServiceCounterService {

    private final ServiceCounterRepository repository;

    public ServiceCounterServiceImpl(ServiceCounterRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceCounter create(ServiceCounter counter) {
        return repository.save(counter);
    }

    @Override
    public List<ServiceCounter> getAll() {
        return repository.findAll();
    }

    @Override
    public ServiceCounter getById(Long id) {
        Optional<ServiceCounter> counter = repository.findById(id);
        return counter.orElse(null); // return null if not found
    }
}

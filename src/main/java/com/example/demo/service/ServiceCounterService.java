package com.example.demo.service;

import com.example.demo.entity.ServiceCounter;
import java.util.List;

public interface ServiceCounterService {
    ServiceCounter createCounter(ServiceCounter counter);
    List<ServiceCounter> getAllCounters();
    ServiceCounter getCounterById(Long id);
    ServiceCounter updateCounter(Long id, ServiceCounter counter);
    void deleteCounter(Long id);
}
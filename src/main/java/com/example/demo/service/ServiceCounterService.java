package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;

// ServiceCounterService.java
interface ServiceCounterService {
    ServiceCounter addCounter(ServiceCounter counter);
    ServiceCounter getCounterById(Long id);
    List<ServiceCounter> getAllCounters();
    List<ServiceCounter> getActiveCounters();
    ServiceCounter updateCounter(Long id, ServiceCounter counter);
    void deleteCounter(Long id);
}
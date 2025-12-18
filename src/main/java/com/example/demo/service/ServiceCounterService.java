package com.example.service;

import java.util.List;

import com.example.demo.model.ServiceCounter;

public interface ServiceCounterService {

    ServiceCounter addCounter(ServiceCounter counter);

    List<ServiceCounter> getActiveCounters();
}

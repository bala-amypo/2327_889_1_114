package com.example.tokenmanagement.service;

import java.util.List;

import com.example.tokenmanagement.model.ServiceCounter;

public interface ServiceCounterService {

    ServiceCounter addCounter(ServiceCounter counter);

    List<ServiceCounter> getActiveCounters();
}

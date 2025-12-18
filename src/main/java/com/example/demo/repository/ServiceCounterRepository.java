package com.example.queue.repository;

import com.example.queue.model.ServiceCounter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceCounterRepository extends JpaRepository<ServiceCounter, Long> {
    List<ServiceCounter> findByIsActiveTrue();
}

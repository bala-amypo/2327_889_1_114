package com.example.demo.repository;

import com.example.demo.entity.ServiceCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCounterRepository extends JpaRepository<ServiceCounter, Long> {
    boolean existsByName(String name);
}
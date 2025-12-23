package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// ServiceCounterRepository.java
@Repository
interface ServiceCounterRepository extends JpaRepository<ServiceCounter, Long> {
    List<ServiceCounter> findByIsActiveTrue();
    Optional<ServiceCounter> findByName(String name);
}
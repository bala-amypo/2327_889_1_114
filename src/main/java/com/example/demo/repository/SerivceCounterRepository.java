package com.example.tokenmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tokenmanagement.model.ServiceCounter;

public interface ServiceCounterRepository extends JpaRepository<ServiceCounter, Long> {

    List<ServiceCounter> findByIsActiveTrue();

}

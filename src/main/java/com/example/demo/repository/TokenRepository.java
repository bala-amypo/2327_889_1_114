package com.example.demo.repository;

import com.example.demo.entity.BreachAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<BreachAlert, Long> {
}

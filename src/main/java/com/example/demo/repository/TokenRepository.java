package com.example.demo.repository;

import com.example.demo.entity.BreachAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<BreachAlert, Long> {

    Optional<BreachAlert> findByTokenNumber(String tokenNumber);
}

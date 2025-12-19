package com.example.demo.repository;

import com.example.demo.entity.TemperatureReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureReadingRepository extends JpaRepository<TemperatureReading, Long> {
}

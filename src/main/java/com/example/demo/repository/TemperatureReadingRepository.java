package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;



// TemperatureReadingRepository.java
@Repository
interface TemperatureReadingRepository extends JpaRepository<TemperatureReading, Long> {
    List<TemperatureReading> findByColdRoomIdOrderByRecordedAtDesc(Long coldRoomId);
    List<TemperatureReading> findBySensorIdOrderByRecordedAtDesc(Long sensorId);
}


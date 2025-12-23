package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

// ColdRoomRepository.java
@Repository
interface ColdRoomRepository extends JpaRepository<ColdRoom, Long> {
    Optional<ColdRoom> findByName(String name);
    List<ColdRoom> findByLocation(String location);
}

// SensorDeviceRepository.java
@Repository
interface SensorDeviceRepository extends JpaRepository<SensorDevice, Long> {
    Optional<SensorDevice> findByIdentifier(String identifier);
    boolean existsByIdentifier(String identifier);
    List<SensorDevice> findByColdRoomId(Long coldRoomId);
    List<SensorDevice> findByIsActiveTrue();
}

// TemperatureReadingRepository.java
@Repository
interface TemperatureReadingRepository extends JpaRepository<TemperatureReading, Long> {
    List<TemperatureReading> findByColdRoomIdOrderByRecordedAtDesc(Long coldRoomId);
    List<TemperatureReading> findBySensorIdOrderByRecordedAtDesc(Long sensorId);
}
 Optional<ServiceCounter> findByName(String name);
}
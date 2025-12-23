package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


// SensorDeviceRepository.java
@Repository
interface SensorDeviceRepository extends JpaRepository<SensorDevice, Long> {
    Optional<SensorDevice> findByIdentifier(String identifier);
    boolean existsByIdentifier(String identifier);
    List<SensorDevice> findByColdRoomId(Long coldRoomId);
    List<SensorDevice> findByIsActiveTrue();
}



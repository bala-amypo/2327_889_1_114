package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;



// SensorService.java
interface SensorService {
    SensorDevice createSensor(SensorDevice sensor);
    SensorDevice getSensorById(Long id);
    SensorDevice getSensorByIdentifier(String identifier);
    List<SensorDevice> getAllSensors();
    List<SensorDevice> getSensorsByColdRoom(Long coldRoomId);
    SensorDevice updateSensorStatus(Long id, Boolean isActive);
    void deleteSensor(Long id);
}


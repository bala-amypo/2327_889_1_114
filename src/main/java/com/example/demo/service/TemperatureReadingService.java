package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;
// TemperatureReadingService.java
interface TemperatureReadingService {
    TemperatureReading recordReading(String sensorIdentifier, Double value);
    TemperatureReading getReadingById(Long id);
    List<TemperatureReading> getReadingsByColdRoom(Long coldRoomId);
    List<TemperatureReading> getReadingsBySensor(Long sensorId);
}


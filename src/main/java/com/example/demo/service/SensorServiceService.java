package com.example.demo.service;

import com.example.demo.entity.SensorDevice;

import java.util.List;

public interface SensorService {

    SensorDevice addSensor(SensorDevice sensor);

    SensorDevice updateStatus(Long id, Boolean isActive);

    List<SensorDevice> getAllSensors();

    SensorDevice getByIdentifier(String identifier);
}

package com.example.demo.service.impl;

import com.example.demo.entity.SensorDevice;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SensorDeviceRepository;
import com.example.demo.service.SensorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorDeviceRepository sensorRepository;

    public SensorServiceImpl(SensorDeviceRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public SensorDevice addSensor(SensorDevice sensor) {

        if (sensorRepository.findByIdentifier(sensor.getIdentifier()).isPresent()) {
            throw new IllegalArgumentException("identifier already exists");
        }

        return sensorRepository.save(sensor);
    }

    @Override
    public SensorDevice updateStatus(Long id, Boolean isActive) {
        SensorDevice sensor = sensorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sensor not found"));

        sensor.setIsActive(isActive);
        return sensorRepository.save(sensor);
    }

    @Override
    public List<SensorDevice> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public SensorDevice getByIdentifier(String identifier) {
        return sensorRepository.findByIdentifier(identifier)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sensor not found"));
    }
}

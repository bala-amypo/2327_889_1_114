package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.TemperatureReadingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemperatureReadingServiceImpl implements TemperatureReadingService {

    private final TemperatureReadingRepository readingRepository;
    private final SensorDeviceRepository sensorRepository;
    private final TokenRepository tokenRepository;

    public TemperatureReadingServiceImpl(TemperatureReadingRepository readingRepository,
                                         SensorDeviceRepository sensorRepository,
                                         TokenRepository tokenRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public TemperatureReading recordReading(TemperatureReading reading) {

        SensorDevice sensor = reading.getSensor();

        if (!sensor.getIsActive()) {
            throw new IllegalArgumentException("Sensor not active");
        }

        if (reading.getRecordedAt().isAfter(LocalDateTime.now().plusMinutes(1))) {
            throw new IllegalArgumentException("Invalid reading time");
        }

        TemperatureReading saved = readingRepository.save(reading);

        ColdRoom room = reading.getColdRoom();

        if (reading.getReadingValue() < room.getMinAllowed() ||
            reading.getReadingValue() > room.getMaxAllowed()) {

            BreachAlert alert = new BreachAlert(
                    "ALERT-" + System.currentTimeMillis(),
                    room,
                    sensor,
                    saved,
                    "OPEN",
                    reading.getReadingValue() > room.getMaxAllowed() ? "HIGH" : "LOW",
                    LocalDateTime.now(),
                    null
            );

            tokenRepository.save(alert);
        }

        return saved;
    }

    @Override
    public List<TemperatureReading> getReadingsByColdRoom(Long coldRoomId) {
        return readingRepository.findByColdRoomId(coldRoomId);
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_readings")
public class TemperatureReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SensorDevice sensor;

    @ManyToOne
    private ColdRoom coldRoom;

    private Double readingValue;

    private LocalDateTime recordedAt;

    public TemperatureReading() {}

    public TemperatureReading(SensorDevice sensor, ColdRoom coldRoom,
                              Double readingValue, LocalDateTime recordedAt) {
        this.sensor = sensor;
        this.coldRoom = coldRoom;
        this.readingValue = readingValue;
        this.recordedAt = recordedAt;
    }

    // getters & setters
}

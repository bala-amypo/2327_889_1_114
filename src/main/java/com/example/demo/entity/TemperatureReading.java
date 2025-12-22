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

    // No-arg constructor
    public TemperatureReading() {
    }

    // Parameterized constructor
    public TemperatureReading(
            SensorDevice sensor,
            ColdRoom coldRoom,
            Double readingValue,
            LocalDateTime recordedAt) {
        this.sensor = sensor;
        this.coldRoom = coldRoom;
        this.readingValue = readingValue;
        this.recordedAt = recordedAt;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public SensorDevice getSensor() {
        return sensor;
    }

    public ColdRoom getColdRoom() {
        return coldRoom;
    }

    public Double getReadingValue() {
        return readingValue;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSensor(SensorDevice sensor) {
        this.sensor = sensor;
    }

    public void setColdRoom(ColdRoom coldRoom) {
        this.coldRoom = coldRoom;
    }

    public void setReadingValue(Double readingValue) {
        this.readingValue = readingValue;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}

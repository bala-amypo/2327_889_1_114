package com.example.demo.dto;

import java.time.LocalDateTime;

public class TemperatureReadingRequest {

    private String sensorIdentifier;
    private Double readingValue;
    private LocalDateTime recordedAt;

    public TemperatureReadingRequest() {
    }

    public String getSensorIdentifier() {
        return sensorIdentifier;
    }

    public Double getReadingValue() {
        return readingValue;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }
}

package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

// TemperatureReadingRequest.java
public class TemperatureReadingRequest {
    
    @NotBlank(message = "Sensor identifier is required")
    private String sensorIdentifier;
    
    @NotNull(message = "Reading value is required")
    private Double readingValue;
    
    private LocalDateTime recordedAt; // Optional, defaults to current time
    
    public TemperatureReadingRequest() {
    }
    
    public TemperatureReadingRequest(String sensorIdentifier, Double readingValue, LocalDateTime recordedAt) {
        this.sensorIdentifier = sensorIdentifier;
        this.readingValue = readingValue;
        this.recordedAt = recordedAt;
    }
    
    public String getSensorIdentifier() {
        return sensorIdentifier;
    }
    
    public void setSensorIdentifier(String sensorIdentifier) {
        this.sensorIdentifier = sensorIdentifier;
    }
    
    public Double getReadingValue() {
        return readingValue;
    }
    
    public void setReadingValue(Double readingValue) {
        this.readingValue = readingValue;
    }
    
    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }
    
    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}


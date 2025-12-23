package com.example.demo.dto;

import java.time.LocalDateTime;

public class TemperatureReadingResponse {
    
    private Long id;
    private String sensorIdentifier;
    private String coldRoomName;
    private Double readingValue;
    private LocalDateTime recordedAt;
    private Boolean breachDetected;
    private String breachType;
    
    public TemperatureReadingResponse() {
    }
    
    public TemperatureReadingResponse(Long id, String sensorIdentifier, String coldRoomName, 
                                     Double readingValue, LocalDateTime recordedAt, 
                                     Boolean breachDetected, String breachType) {
        this.id = id;
        this.sensorIdentifier = sensorIdentifier;
        this.coldRoomName = coldRoomName;
        this.readingValue = readingValue;
        this.recordedAt = recordedAt;
        this.breachDetected = breachDetected;
        this.breachType = breachType;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSensorIdentifier() {
        return sensorIdentifier;
    }
    
    public void setSensorIdentifier(String sensorIdentifier) {
        this.sensorIdentifier = sensorIdentifier;
    }
    
    public String getColdRoomName() {
        return coldRoomName;
    }
    
    public void setColdRoomName(String coldRoomName) {
        this.coldRoomName = coldRoomName;
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
    
    public Boolean getBreachDetected() {
        return breachDetected;
    }
    
    public void setBreachDetected(Boolean breachDetected) {
        this.breachDetected = breachDetected;
    }
    
    public String getBreachType() {
        return breachType;
    }
    
    public void setBreachType(String breachType) {
        this.breachType = breachType;
    }
}
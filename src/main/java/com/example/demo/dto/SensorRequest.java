package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SensorRequest {
    
    @NotBlank(message = "Sensor identifier is required")
    private String identifier;
    
    @NotNull(message = "Cold room ID is required")
    private Long coldRoomId;
    
    @NotNull(message = "Active status is required")
    private Boolean isActive;
    
    public SensorRequest() {
    }
    
    public SensorRequest(String identifier, Long coldRoomId, Boolean isActive) {
        this.identifier = identifier;
        this.coldRoomId = coldRoomId;
        this.isActive = isActive;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    public Long getColdRoomId() {
        return coldRoomId;
    }
    
    public void setColdRoomId(Long coldRoomId) {
        this.coldRoomId = coldRoomId;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
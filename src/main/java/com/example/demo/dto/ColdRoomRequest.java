package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// ColdRoomRequest.java
public class ColdRoomRequest {
    
    @NotBlank(message = "Cold room name is required")
    private String name;
    
    @NotBlank(message = "Location is required")
    private String location;
    
    @NotNull(message = "Minimum allowed temperature is required")
    private Double minAllowed;
    
    @NotNull(message = "Maximum allowed temperature is required")
    private Double maxAllowed;
    
    public ColdRoomRequest() {
    }
    
    public ColdRoomRequest(String name, String location, Double minAllowed, Double maxAllowed) {
        this.name = name;
        this.location = location;
        this.minAllowed = minAllowed;
        this.maxAllowed = maxAllowed;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public Double getMinAllowed() {
        return minAllowed;
    }
    
    public void setMinAllowed(Double minAllowed) {
        this.minAllowed = minAllowed;
    }
    
    public Double getMaxAllowed() {
        return maxAllowed;
    }
    
    public void setMaxAllowed(Double maxAllowed) {
        this.maxAllowed = maxAllowed;
    }
}


package com.example.demo.dto;

public class SensorRequest {

    private String identifier;
    private Long coldRoomId;
    private Boolean isActive;

    public SensorRequest() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public Long getColdRoomId() {
        return coldRoomId;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}

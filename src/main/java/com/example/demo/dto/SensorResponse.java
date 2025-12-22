package com.example.demo.dto;

public class SensorResponse {

    private Long id;
    private String identifier;
    private Long coldRoomId;
    private String coldRoomName;
    private Boolean isActive;

    public SensorResponse(Long id, String identifier,
                          Long coldRoomId, String coldRoomName,
                          Boolean isActive) {
        this.id = id;
        this.identifier = identifier;
        this.coldRoomId = coldRoomId;
        this.coldRoomName = coldRoomName;
        this.isActive = isActive;
    }
}

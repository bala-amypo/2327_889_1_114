package com.example.demo.dto;

public class ColdRoomRequest {

    private String name;
    private String location;
    private Double minAllowed;
    private Double maxAllowed;

    public ColdRoomRequest() {
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Double getMinAllowed() {
        return minAllowed;
    }

    public Double getMaxAllowed() {
        return maxAllowed;
    }
}

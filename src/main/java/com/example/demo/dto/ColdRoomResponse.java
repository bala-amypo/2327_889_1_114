package com.example.demo.dto;

public class ColdRoomResponse {

    private Long id;
    private String name;
    private String location;
    private Double minAllowed;
    private Double maxAllowed;

    public ColdRoomResponse(Long id, String name, String location,
                            Double minAllowed, Double maxAllowed) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.minAllowed = minAllowed;
        this.maxAllowed = maxAllowed;
    }

    public Long getId() {
        return id;
    }
}

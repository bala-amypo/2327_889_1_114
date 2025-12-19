package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sensor_devices", uniqueConstraints = @UniqueConstraint(columnNames = "identifier"))
public class SensorDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identifier;

    @ManyToOne
    @JoinColumn(name = "cold_room_id")
    private ColdRoom coldRoom;

    private Boolean isActive;

    public SensorDevice() {}

    public SensorDevice(String identifier, ColdRoom coldRoom, Boolean isActive) {
        this.identifier = identifier;
        this.coldRoom = coldRoom;
        this.isActive = isActive;
    }

    // getters & setters
}

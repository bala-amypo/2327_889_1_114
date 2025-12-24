package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sensor_devices")
public class SensorDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String deviceName;
    private String deviceType;
    private Boolean isActive;
    
    // Getters and Setters
}
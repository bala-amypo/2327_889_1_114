package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cold_rooms")
public class ColdRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @Column(nullable = false)
    private Double minAllowed;

    @Column(nullable = false)
    private Double maxAllowed;

    @OneToMany(mappedBy = "coldRoom")
    private List<SensorDevice> sensors;

    // No-arg constructor
    public ColdRoom() {
    }

    // Parameterized constructor
    public ColdRoom(String name, String location, Double minAllowed, Double maxAllowed) {
        this.name = name;
        this.location = location;
        this.minAllowed = minAllowed;
        this.maxAllowed = maxAllowed;
    }

    // Getters & Setters
    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMinAllowed(Double minAllowed) {
        this.minAllowed = minAllowed;
    }

    public void setMaxAllowed(Double maxAllowed) {
        this.maxAllowed = maxAllowed;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cold_rooms")
public class ColdRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String roomName;
    private Double minTemperature;
    private Double maxTemperature;
    
    // Getters and Setters
}
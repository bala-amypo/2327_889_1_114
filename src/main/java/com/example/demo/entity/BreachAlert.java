package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breach_alerts")
public class BreachAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String alertType;
    private String message;
    private LocalDateTime timestamp;
    
    // Getters and Setters
}
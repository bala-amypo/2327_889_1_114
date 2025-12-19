// src/main/java/com/example/demo/entity/ServiceCounter.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "service_counters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "counter_name", nullable = false)
    private String counterName;
    
    @Column(nullable = false)
    private String department;
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
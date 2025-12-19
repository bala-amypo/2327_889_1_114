// src/main/java/com/example/demo/entity/ServiceCounter.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "service_counter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String counterName;
    private String department;
    private Boolean isActive = true;
}
// src/main/java/com/example/demo/entity/Token.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "tokens", uniqueConstraints = {
    @UniqueConstraint(columnNames = "token_number")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "token_number", nullable = false, unique = true)
    private String tokenNumber;
    
    @ManyToOne
    @JoinColumn(name = "service_counter_id")
    private ServiceCounter serviceCounter;
    
    @Column(nullable = false)
    private String status = "WAITING"; // WAITING, SERVING, COMPLETED, CANCELLED
    
    @Column(name = "issued_at", nullable = false)
    private LocalDateTime issuedAt;
    
    @Column(name = "completed_at")
    private LocalDateTime completedAt;
    
    @PreUpdate
    public void preUpdate() {
        if ("COMPLETED".equals(status) && completedAt == null) {
            completedAt = LocalDateTime.now();
        }
    }
}
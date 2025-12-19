// src/main/java/com/example/demo/entity/QueuePosition.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "queue_positions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueuePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "token_id", nullable = false)
    private Token token;
    
    @Column(nullable = false)
    private Integer position = 1;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}
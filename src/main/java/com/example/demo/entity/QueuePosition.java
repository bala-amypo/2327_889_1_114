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
    @JoinColumn(name = "token_id")
    private Token token;
    
    private Integer position = 1;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
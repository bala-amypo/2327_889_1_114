package com.example.queue.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class QueuePosition {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Token token;

    @Column(nullable = false)
    private Integer position;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // getters and setters
}

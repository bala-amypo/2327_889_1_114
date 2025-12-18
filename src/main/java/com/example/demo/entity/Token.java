package com.example.queue.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Token {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tokenNumber;

    @ManyToOne(optional = false)
    private ServiceCounter serviceCounter;

    @Column(nullable = false)
    private String status;  // WAITING / SERVING / COMPLETED / CANCELLED

    @Column(nullable = false)
    private LocalDateTime issuedAt;

    private LocalDateTime completedAt;

    // getters and setters
}

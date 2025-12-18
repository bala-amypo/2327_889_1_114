package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @Column(name = "counter_number", nullable = false, unique = true)
    private Integer counterNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CounterStatus status = CounterStatus.ACTIVE;

    @Column(name = "current_token_id")
    private Long currentTokenId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum CounterStatus {
        ACTIVE,
        INACTIVE,
        BUSY,
        AVAILABLE
    }
}

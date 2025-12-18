package com.example.queue.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tokenNumber;

    @ManyToOne(optional = false)
    private ServiceCounter serviceCounter;

    @Column(nullable = false)
    private String status; // WAITING / SERVING / COMPLETED / CANCELLED

    @Column(nullable = false)
    private LocalDateTime issuedAt;

    private LocalDateTime completedAt;

    public Token() {
    }

    public Token(Long id,
                 String tokenNumber,
                 ServiceCounter serviceCounter,
                 String status,
                 LocalDateTime issuedAt,
                 LocalDateTime completedAt) {
        this.id = id;
        this.tokenNumber = tokenNumber;
        this.serviceCounter = serviceCounter;
        this.status = status;
        this.issuedAt = issuedAt;
        this.completedAt = completedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public ServiceCounter getServiceCounter() {
        return serviceCounter;
    }

    public void setServiceCounter(ServiceCounter serviceCounter) {
        this.serviceCounter = serviceCounter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}

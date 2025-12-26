package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Token {

    @Id
    @GeneratedValue
    private Long id;

    private int number;

    @Enumerated(EnumType.STRING)
    private TokenStatus status;

    private LocalDateTime completedAt;

    public Long getId() { return id; }
    public int getNumber() { return number; }
    public TokenStatus getStatus() { return status; }
    public LocalDateTime getCompletedAt() { return completedAt; }

    public void setId(Long id) { this.id = id; }
    public void setNumber(int number) { this.number = number; }
    public void setStatus(TokenStatus status) { this.status = status; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
}

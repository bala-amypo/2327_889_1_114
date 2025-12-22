package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "token_logs")
public class TokenLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BreachAlert token;

    private String logMessage;

    private LocalDateTime loggedAt;

    public TokenLog() {
    }

    public TokenLog(BreachAlert token, String logMessage, LocalDateTime loggedAt) {
        this.token = token;
        this.logMessage = logMessage;
        this.loggedAt = loggedAt;
    }

    public Long getId() {
        return id;
    }

    public BreachAlert getToken() {
        return token;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}

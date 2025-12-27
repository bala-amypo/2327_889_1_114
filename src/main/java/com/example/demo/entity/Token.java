package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tokenValue;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_counter_id")
    private ServiceCounter serviceCounter;

    public Token() {}

    // Getters and setters
    public Long getId() { return id; }
    public String getTokenValue() { return tokenValue; }
    public User getUser() { return user; }
    public ServiceCounter getServiceCounter() { return serviceCounter; }

    public void setId(Long id) { this.id = id; }
    public void setTokenValue(String tokenValue) { this.tokenValue = tokenValue; }
    public void setUser(User user) { this.user = user; }
    public void setServiceCounter(ServiceCounter serviceCounter) { this.serviceCounter = serviceCounter; }
}

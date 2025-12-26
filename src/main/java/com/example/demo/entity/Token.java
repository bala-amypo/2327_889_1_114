// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class Token {

//     @Id
//     @GeneratedValue
//     private Long id;

//     @Column(unique = true)
//     private String tokenNumber;

//     @ManyToOne
//     private ServiceCounter serviceCounter;

//     private String status;
//     private LocalDateTime issuedAt = LocalDateTime.now();
//     private LocalDateTime completedAt;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getTokenNumber() { return tokenNumber; }
//     public void setTokenNumber(String tokenNumber) { this.tokenNumber = tokenNumber; }

//     public ServiceCounter getServiceCounter() { return serviceCounter; }
//     public void setServiceCounter(ServiceCounter serviceCounter) { this.serviceCounter = serviceCounter; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }

//     public LocalDateTime getIssuedAt() { return issuedAt; }

//     public LocalDateTime getCompletedAt() { return completedAt; }
//     public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TokenStatus status;

    @ManyToOne
    @JoinColumn(name = "service_counter_id")
    private ServiceCounter serviceCounter;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public TokenStatus getStatus() { return status; }
    public void setStatus(TokenStatus status) { this.status = status; }

    public ServiceCounter getServiceCounter() { return serviceCounter; }
    public void setServiceCounter(ServiceCounter serviceCounter) { this.serviceCounter = serviceCounter; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

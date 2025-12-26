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

//     private String status = "WAITING";

//     @ManyToOne
//     private ServiceCounter serviceCounter;

//     private LocalDateTime issuedAt = LocalDateTime.now();
//     private LocalDateTime completedAt;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getTokenNumber() { return tokenNumber; }
//     public void setTokenNumber(String tokenNumber) { this.tokenNumber = tokenNumber; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }

//     public ServiceCounter getServiceCounter() { return serviceCounter; }
//     public void setServiceCounter(ServiceCounter serviceCounter) { this.serviceCounter = serviceCounter; }

//     public LocalDateTime getIssuedAt() { return issuedAt; }
//     public LocalDateTime getCompletedAt() { return completedAt; }
//     public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
// }
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer queuePosition;

    // Other fields...

    // Getter and Setter for queuePosition
    public Integer getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(Integer queuePosition) {
        this.queuePosition = queuePosition;
    }

    // Other getters and setters...
}

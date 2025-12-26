// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     @Column(nullable = false)
//     private String role;   // 👈 ADD THIS

//     public User() {}

//     public User(String email, String password, String role) {
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }

//     public Long getId() {
//         return id;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public String getRole() {     // 👈 THIS FIXES YOUR ERROR
//         return role;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Token {

    @Id
    @GeneratedValue
    private Long id;

    private String tokenNumber;

    @Enumerated(EnumType.STRING)
    private TokenStatus status;

    private LocalDateTime issuedAt;
    private LocalDateTime completedAt;

    @ManyToOne
    private ServiceCounter serviceCounter;

    public Long getId() { return id; }
    public String getTokenNumber() { return tokenNumber; }
    public TokenStatus getStatus() { return status; }
    public LocalDateTime getIssuedAt() { return issuedAt; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public ServiceCounter getServiceCounter() { return serviceCounter; }

    public void setId(Long id) { this.id = id; }
    public void setTokenNumber(String tokenNumber) { this.tokenNumber = tokenNumber; }
    public void setStatus(TokenStatus status) { this.status = status; }
    public void setIssuedAt(LocalDateTime issuedAt) { this.issuedAt = issuedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
    public void setServiceCounter(ServiceCounter serviceCounter) { this.serviceCounter = serviceCounter; }
}

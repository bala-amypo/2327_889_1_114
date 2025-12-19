// src/main/java/com/example/demo/entity/TokenLog.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "token_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "token_id")
    private Token token;
    
    private String logMessage;
    private LocalDateTime loggedAt = LocalDateTime.now();
}
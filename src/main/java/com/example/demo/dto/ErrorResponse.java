// src/main/java/com/example/demo/dto/ErrorResponse.java
package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
package com.example.demo.dto;

import java.time.LocalDateTime;

public class QueuePositionResponse {

    private String tokenNumber;
    private Integer position;
    private LocalDateTime updatedAt;

    public QueuePositionResponse(String tokenNumber, Integer position, LocalDateTime updatedAt) {
        this.tokenNumber = tokenNumber;
        this.position = position;
        this.updatedAt = updatedAt;
    }
}

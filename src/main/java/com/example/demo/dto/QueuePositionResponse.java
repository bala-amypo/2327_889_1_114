package com.example.demo.dto;

import java.time.LocalDateTime;

// QueuePositionResponse.java
class QueuePositionResponse {
    private String tokenNumber;
    private Integer position;
    private LocalDateTime updatedAt;
    
    public QueuePositionResponse() {}
    
    public QueuePositionResponse(String tokenNumber, Integer position, LocalDateTime updatedAt) {
        this.tokenNumber = tokenNumber;
        this.position = position;
        this.updatedAt = updatedAt;
    }
    
    public String getTokenNumber() { return tokenNumber; }
    public void setTokenNumber(String tokenNumber) { this.tokenNumber = tokenNumber; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
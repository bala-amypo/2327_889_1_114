
package com.example.demo.dto;

import java.time.LocalDateTime;

// TokenLogResponse.java
class TokenLogResponse {
    private Long id;
    private String tokenNumber;
    private String logMessage;
    private LocalDateTime loggedAt;
    
    public TokenLogResponse() {}
    
    public TokenLogResponse(Long id, String tokenNumber, String logMessage, LocalDateTime loggedAt) {
        this.id = id;
        this.tokenNumber = tokenNumber;
        this.logMessage = logMessage;
        this.loggedAt = loggedAt;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTokenNumber() { return tokenNumber; }
    public void setTokenNumber(String tokenNumber) { this.tokenNumber = tokenNumber; }
    public String getLogMessage() { return logMessage; }
    public void setLogMessage(String logMessage) { this.logMessage = logMessage; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
}


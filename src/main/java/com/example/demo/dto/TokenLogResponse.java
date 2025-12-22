package com.example.demo.dto;

import java.time.LocalDateTime;

public class TokenLogResponse {

    private Long id;
    private String tokenNumber;
    private String logMessage;
    private LocalDateTime loggedAt;

    public TokenLogResponse(Long id, String tokenNumber, String logMessage, LocalDateTime loggedAt) {
        this.id = id;
        this.tokenNumber = tokenNumber;
        this.logMessage = logMessage;
        this.loggedAt = loggedAt;
    }
}

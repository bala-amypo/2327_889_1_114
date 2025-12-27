package com.example.demo.dto;

public class TokenResponseDTO {
    private String tokenNumber;
    private String status;
    private Integer position;

    public TokenResponseDTO(String tokenNumber, String status, Integer position) {
        this.tokenNumber = tokenNumber;
        this.status = status;
        this.position = position;
    }

    public String getTokenNumber() { return tokenNumber; }
    public String getStatus() { return status; }
    public Integer getPosition() { return position; }
}

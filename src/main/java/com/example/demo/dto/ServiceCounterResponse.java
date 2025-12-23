package com.example.demo.dto;

import java.time.LocalDateTime;

class ServiceCounterResponse {
    private Long id;
    private String name;
    private Boolean isActive;
    private String description;
    
    public ServiceCounterResponse() {}
    
    public ServiceCounterResponse(Long id, String name, Boolean isActive, String description) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
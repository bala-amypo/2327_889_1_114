package com.example.queue.model;

import jakarta.persistence.*;

@Entity
public class ServiceCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String counterName;

    private String department;

    @Column(nullable = false)
    private Boolean isActive = Boolean.TRUE;

    public ServiceCounter() {
    }

    public ServiceCounter(Long id, String counterName, String department, Boolean isActive) {
        this.id = id;
        this.counterName = counterName;
        this.department = department;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public String getDepartment() {
        return department;
    }

    public
}
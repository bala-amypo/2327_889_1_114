package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service_counters")
public class ServiceCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String counterName;

    private boolean active;

    public ServiceCounter() {}

    public ServiceCounter(Long id, String counterName, boolean active) {
        this.id = id;
        this.counterName = counterName;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getCounterName() {
        return counterName;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}


package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class QueuePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer position;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
}

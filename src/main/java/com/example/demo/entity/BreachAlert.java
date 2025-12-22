package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "breach_alerts",
    uniqueConstraints = @UniqueConstraint(columnNames = "tokenNumber")
)
public class BreachAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tokenNumber;

    @ManyToOne
    private ColdRoom coldRoom;

    @ManyToOne
    private SensorDevice sensor;

    @ManyToOne
    private TemperatureReading reading;

    private String status;
    private String breachType;

    private LocalDateTime issuedAt;
    private LocalDateTime resolvedAt;

    @OneToOne(mappedBy = "token")
    private QueuePosition queuePosition;

    @OneToMany(mappedBy = "token")
    private List<TokenLog> logs;

    // No-arg constructor
    public BreachAlert() {
    }

    // Parameterized constructor
    public BreachAlert(
            String tokenNumber,
            ColdRoom coldRoom,
            SensorDevice sensor,
            TemperatureReading reading,
            String status,
            String breachType,
            LocalDateTime issuedAt,
            LocalDateTime resolvedAt) {
        this.tokenNumber = tokenNumber;
        this.coldRoom = coldRoom;
        this.sensor = sensor;
        this.reading = reading;
        this.status = status;
        this.breachType = breachType;
        this.issuedAt = issuedAt;
        this.resolvedAt = resolvedAt;
    }

    // Getters & Setters omitted for brevity (same pattern)
}

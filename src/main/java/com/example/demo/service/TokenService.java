package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;


// TokenService.java
interface TokenService {
    BreachAlert issueToken(Long counterId);
    BreachAlert createBreachAlert(TemperatureReading reading, String breachType);
    BreachAlert updateStatus(Long tokenId, String status);
    BreachAlert getToken(Long tokenId);
    BreachAlert getTokenByNumber(String tokenNumber);
    List<BreachAlert> getTokensByStatus(String status);
}

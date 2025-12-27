package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TokenServiceImpl {
    private final TokenRepository tokenRepository;
    private final ServiceCounterRepository counterRepository;
    private final TokenLogRepository logRepository;
    private final QueuePositionRepository queueRepository;
    
    public TokenServiceImpl(TokenRepository tokenRepository, 
                           ServiceCounterRepository counterRepository,
                           TokenLogRepository logRepository,
                           QueuePositionRepository queueRepository) {
        this.tokenRepository = tokenRepository;
        this.counterRepository = counterRepository;
        this.logRepository = logRepository;
        this.queueRepository = queueRepository;
    }
    
    public Token issueToken(Long counterId) {
        ServiceCounter counter = counterRepository.findById(counterId)
            .orElseThrow(() -> new RuntimeException("Counter not found"));
            
        if (!counter.getIsActive()) {
            throw new IllegalArgumentException("Counter is not active");
        }
        
        Token token = new Token();
        token.setTokenNumber(generateTokenNumber());
        token.setServiceCounter(counter);
        token.setStatus("WAITING");
        token.setIssuedAt(LocalDateTime.now());
        
        token = tokenRepository.save(token);
        
        // Create queue position
        List<Token> waitingTokens = tokenRepository.findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(counterId, "WAITING");
        QueuePosition queuePosition = new QueuePosition();
        queuePosition.setToken(token);
        queuePosition.setPosition(waitingTokens.size());
        queuePosition.setUpdatedAt(LocalDateTime.now());
        queueRepository.save(queuePosition);
        
        // Create log entry
        TokenLog log = new TokenLog();
        log.setToken(token);
        log.setLogMessage("Token issued");
        log.setLoggedAt(LocalDateTime.now());
        logRepository.save(log);
        
        return token;
    }
    
    public Token updateStatus(Long tokenId, String newStatus) {
        Token token = tokenRepository.findById(tokenId)
            .orElseThrow(() -> new RuntimeException("Token not found"));
            
        String currentStatus = token.getStatus();
        
        // Validate status transitions
        if (!isValidTransition(currentStatus, newStatus)) {
            throw new IllegalArgumentException("Invalid status transition from " + currentStatus + " to " + newStatus);
        }
        
        token.setStatus(newStatus);
        
        if ("COMPLETED".equals(newStatus) || "CANCELLED".equals(newStatus)) {
            token.setCompletedAt(LocalDateTime.now());
        }
        
        token = tokenRepository.save(token);
        
        // Create log entry
        TokenLog log = new TokenLog();
        log.setToken(token);
        log.setLogMessage("Status updated to " + newStatus);
        log.setLoggedAt(LocalDateTime.now());
        logRepository.save(log);
        
        return token;
    }
    
    public Token getToken(Long tokenId) {
        return tokenRepository.findById(tokenId)
            .orElseThrow(() -> new RuntimeException("Token not found"));
    }
    
    private String generateTokenNumber() {
        return "T-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    
    private boolean isValidTransition(String from, String to) {
        if ("WAITING".equals(from)) {
            return "SERVING".equals(to) || "CANCELLED".equals(to);
        }
        if ("SERVING".equals(from)) {
            return "COMPLETED".equals(to) || "CANCELLED".equals(to);
        }
        return false;
    }
}
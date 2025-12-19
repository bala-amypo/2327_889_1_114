// src/main/java/com/example/demo/service/TokenService.java
package com.example.demo.service;

import com.example.demo.entity.Token;
import com.example.demo.entity.ServiceCounter;
import com.example.demo.entity.TokenLog;
import com.example.demo.exception.InvalidOperationException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.ServiceCounterRepository;
import com.example.demo.repository.TokenLogRepository;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.util.TokenNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;
    private final ServiceCounterRepository serviceCounterRepository;
    private final TokenLogRepository tokenLogRepository;
    private final QueuePositionRepository queuePositionRepository;
    private final TokenNumberGenerator tokenNumberGenerator;

    @Transactional
    public Token issueToken(Long counterId) {
        ServiceCounter counter = serviceCounterRepository.findById(counterId)
                .orElseThrow(() -> new NotFoundException("Counter not found"));
        
        if (!counter.getIsActive()) {
            throw new InvalidOperationException("Counter not active");
        }
        
        Token token = new Token();
        token.setTokenNumber(tokenNumberGenerator.generateTokenNumber());
        token.setServiceCounter(counter);
        token.setStatus("WAITING");
        token.setIssuedAt(LocalDateTime.now());
        
        Token savedToken = tokenRepository.save(token);
        
        // Create log
        TokenLog log = new TokenLog();
        log.setToken(savedToken);
        log.setLogMessage("Token issued with number: " + savedToken.getTokenNumber());
        tokenLogRepository.save(log);
        
        return savedToken;
    }

    @Transactional
    public Token updateStatus(Long tokenId, String newStatus) {
        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new NotFoundException("Token not found"));
        
        String oldStatus = token.getStatus();
        
        // Validate status transition
        if (!isValidStatusTransition(oldStatus, newStatus)) {
            throw new InvalidOperationException("Invalid status transition");
        }
        
        token.setStatus(newStatus);
        
        if ("COMPLETED".equals(newStatus)) {
            token.setCompletedAt(LocalDateTime.now());
        }
        
        Token updatedToken = tokenRepository.save(token);
        
        // Create log
        TokenLog log = new TokenLog();
        log.setToken(updatedToken);
        log.setLogMessage("Status changed from " + oldStatus + " to " + newStatus);
        tokenLogRepository.save(log);
        
        return updatedToken;
    }

    public Token getToken(Long tokenId) {
        return tokenRepository.findById(tokenId)
                .orElseThrow(() -> new NotFoundException("Token not found"));
    }

    private boolean isValidStatusTransition(String oldStatus, String newStatus) {
        return switch (oldStatus) {
            case "WAITING" -> List.of("SERVING", "CANCELLED").contains(newStatus);
            case "SERVING" -> List.of("COMPLETED", "CANCELLED").contains(newStatus);
            case "COMPLETED", "CANCELLED" -> false;
            default -> false;
        };
    }
}
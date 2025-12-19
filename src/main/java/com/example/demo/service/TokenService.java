package com.example.service.impl;

import com.example.model.Token;
import com.example.repository.TokenRepository;
import com.example.repository.ServiceCounterRepository;
import com.example.service.TokenService;
import com.example.service.TokenLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {
    
    @Autowired
    private TokenRepository tokenRepository;
    
    @Autowired
    private ServiceCounterRepository serviceCounterRepository;
    
    @Autowired
    private TokenLogService tokenLogService;
    
    @Override
    public Token issueToken(Long counterId) {
        return serviceCounterRepository.findById(counterId)
            .filter(counter -> counter.getIsActive())
            .map(counter -> {
                Token token = new Token();
                token.setCounterId(counterId);
                token.setStatus("ISSUED");
                token.setCreatedAt(LocalDateTime.now());
                Token savedToken = tokenRepository.save(token);
                tokenLogService.addLog(savedToken.getId(), "Token issued for counter: " + counterId);
                return savedToken;
            })
            .orElseThrow(() -> new RuntimeException("Counter not active"));
    }
    
    @Override
    public Token updateStatus(Long tokenId, String status) {
        return tokenRepository.findByTokenId(tokenId)
            .map(token -> {
                String oldStatus = token.getStatus();
                if (!isValidTransition(oldStatus, status)) {
                    throw new RuntimeException("Invalid status transition from " + oldStatus + " to " + status);
                }
                token.setStatus(status);
                token.setUpdatedAt(LocalDateTime.now());
                Token updatedToken = tokenRepository.save(token);
                tokenLogService.addLog(tokenId, "Status changed from " + oldStatus + " to " + status);
                return updatedToken;
            })
            .orElseThrow(() -> new RuntimeException("Token not found"));
    }
    
    @Override
    public Optional<Token> getToken(Long tokenId) {
        return tokenRepository.findByTokenId(tokenId);
    }
    
    private boolean isValidTransition(String currentStatus, String newStatus) {
        switch (currentStatus) {
            case "ISSUED":
                return "CALLED".equals(newStatus) || "CANCELLED".equals(newStatus);
            case "CALLED":
                return "SERVING".equals(newStatus) || "CANCELLED".equals(newStatus);
            case "SERVING":
                return "COMPLETED".equals(newStatus) || "CANCELLED".equals(newStatus);
            case "COMPLETED":
            case "CANCELLED":
                return false;
            default:
                return false;
        }
    }
}
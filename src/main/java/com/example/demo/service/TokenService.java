package com.example.service;

import com.example.model.Token;
import com.example.repository.TokenRepository;
import com.example.repository.ServiceCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TokenService {
    
    @Autowired
    private TokenRepository tokenRepository;
    
    @Autowired
    private ServiceCounterRepository serviceCounterRepository;
    
    public Token issueToken(Long counterId) {
        // Check if counter is active
        return serviceCounterRepository.findById(counterId)
            .filter(counter -> counter.getIsActive())
            .map(counter -> {
                Token token = new Token();
                token.setCounterId(counterId);
                token.setStatus("ISSUED");
                return tokenRepository.save(token);
            })
            .orElseThrow(() -> new RuntimeException("Counter not active"));
    }
    
    public Token updateStatus(Long tokenId, String status) {
        // Check valid transitions
        return tokenRepository.findByTokenId(tokenId)
            .map(token -> {
                // Add validation logic for valid status transitions
                if (isValidTransition(token.getStatus(), status)) {
                    token.setStatus(status);
                    return tokenRepository.save(token);
                } else {
                    throw new RuntimeException("Invalid status transition");
                }
            })
            .orElseThrow(() -> new RuntimeException("Token not found"));
    }
    
    public Optional<Token> getToken(Long tokenId) {
        return tokenRepository.findByTokenId(tokenId);
    }
    
    private boolean isValidTransition(String currentStatus, String newStatus) {
        // Add your status transition validation logic here
        // Example: ISSUED -> CALLED -> SERVING -> COMPLETED
        return true; // Implement your logic
    }
}
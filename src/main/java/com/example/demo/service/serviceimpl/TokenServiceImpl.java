package com.example.demo.service.impl;

import com.example.demo.entity.BreachAlert;
import com.example.demo.entity.TokenLog;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TokenLogRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final TokenLogRepository tokenLogRepository;

    public TokenServiceImpl(TokenRepository tokenRepository,
                            TokenLogRepository tokenLogRepository) {
        this.tokenRepository = tokenRepository;
        this.tokenLogRepository = tokenLogRepository;
    }

    @Override
    public BreachAlert getToken(Long tokenId) {
        return tokenRepository.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));
    }

    @Override
    public BreachAlert updateStatus(Long tokenId, String status) {
        BreachAlert token = getToken(tokenId);

        String current = token.getStatus();

        if (!isValidTransition(current, status)) {
            throw new IllegalArgumentException("Invalid status transition");
        }

        token.setStatus(status);

        if ("RESOLVED".equals(status) || "CANCELLED".equals(status)) {
            token.setResolvedAt(LocalDateTime.now());
        } else {
            token.setResolvedAt(null);
        }

        BreachAlert saved = tokenRepository.save(token);

        tokenLogRepository.save(
                new TokenLog(saved, "Status changed to " + status, null)
        );

        return saved;
    }

    private boolean isValidTransition(String from, String to) {
        if ("OPEN".equals(from) &&
                ("ACKNOWLEDGED".equals(to) || "CANCELLED".equals(to))) {
            return true;
        }
        if ("ACKNOWLEDGED".equals(from) &&
                ("RESOLVED".equals(to) || "CANCELLED".equals(to))) {
            return true;
        }
        return false;
    }
}

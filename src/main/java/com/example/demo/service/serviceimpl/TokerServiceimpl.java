package com.example.tokenmanagement.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.tokenmanagement.exception.InvalidStatusException;
import com.example.tokenmanagement.exception.NotActiveException;
import com.example.tokenmanagement.exception.NotFoundException;
import com.example.tokenmanagement.model.ServiceCounter;
import com.example.tokenmanagement.model.Token;
import com.example.tokenmanagement.repository.ServiceCounterRepository;
import com.example.tokenmanagement.repository.TokenRepository;
import com.example.tokenmanagement.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final ServiceCounterRepository counterRepository;

    public TokenServiceImpl(TokenRepository tokenRepository,
                            ServiceCounterRepository counterRepository) {
        this.tokenRepository = tokenRepository;
        this.counterRepository = counterRepository;
    }

    @Override
    public Token issueToken(Long counterId) {

        ServiceCounter counter = counterRepository.findById(counterId)
                .orElseThrow(() -> new NotFoundException("Counter not found"));

        if (!counter.getIsActive()) {
            throw new NotActiveException("Counter not active");
        }

        Token token = new Token();
        token.setServiceCounter(counter);
        token.setTokenNumber("TKN-" + System.currentTimeMillis());
        token.setStatus("WAITING");
        token.setIssuedAt(LocalDateTime.now());

        return tokenRepository.save(token);
    }

    @Override
    public Token updateStatus(Long tokenId, String status) {

        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new NotFoundException("Token not found"));

        String currentStatus = token.getStatus();

        if (currentStatus.equals("WAITING") && status.equals("SERVING") ||
            currentStatus.equals("SERVING") && status.equals("COMPLETED")) {

            token.setStatus(status);

            if (status.equals("COMPLETED")) {
                token.setCompletedAt(LocalDateTime.now());
            }

            return tokenRepository.save(token);
        }

        throw new InvalidStatusException("Invalid status transition");
    }

    @Override
    public Token getToken(Long tokenId) {
        return tokenRepository.findById(tokenId)
                .orElseThrow(() -> new NotFoundException("Token not found"));
    }
}

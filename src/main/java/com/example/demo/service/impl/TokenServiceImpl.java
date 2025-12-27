package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.TokenService;

import java.time.LocalDateTime;
import java.util.UUID;

public class TokenServiceImpl implements TokenService {

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

    @Override
    public Token issueToken(Long counterId) {

        ServiceCounter counter = counterRepository.findById(counterId)
                .orElseThrow(() -> new ResourceNotFoundException("Counter not found"));

        if (!counter.getIsActive()) {
            throw new IllegalArgumentException("Counter not active");
        }

        Token token = new Token();
        token.setServiceCounter(counter);
        token.setStatus("WAITING");
        token.setIssuedAt(LocalDateTime.now());
        token.setTokenNumber(UUID.randomUUID().toString());

        Token saved = tokenRepository.save(token);

        int position = tokenRepository
                .findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(counterId, "WAITING")
                .size();

        QueuePosition qp = new QueuePosition(saved, position, LocalDateTime.now());
        queueRepository.save(qp);

        logRepository.save(new TokenLog(saved, "Token issued", LocalDateTime.now()));

        return saved;
    }

    @Override
    public Token updateStatus(Long tokenId, String status) {

        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));

        String current = token.getStatus();

        if (current.equals("WAITING") && !(status.equals("SERVING") || status.equals("CANCELLED"))) {
            throw new IllegalArgumentException("Invalid status transition");
        }

        if (current.equals("SERVING") && !(status.equals("COMPLETED") || status.equals("CANCELLED"))) {
            throw new IllegalArgumentException("Invalid status transition");
        }

        token.setStatus(status);

        if (status.equals("COMPLETED") || status.equals("CANCELLED")) {
            token.setCompletedAt(LocalDateTime.now());
        }

        Token saved = tokenRepository.save(token);
        logRepository.save(new TokenLog(saved, "Status changed to " + status, LocalDateTime.now()));

        return saved;
    }

    @Override
    public Token getToken(Long tokenId) {
        return tokenRepository.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));
    }
}

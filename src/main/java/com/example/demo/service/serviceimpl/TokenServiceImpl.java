package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.TokenService;
import com.example.demo.util.TokenNumberGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepo;
    private final ServiceCounterRepository counterRepo;
    private final QueuePositionRepository queueRepo;
    private final TokenLogRepository logRepo;

    public TokenServiceImpl(TokenRepository tokenRepo,
                            ServiceCounterRepository counterRepo,
                            QueuePositionRepository queueRepo,
                            TokenLogRepository logRepo) {
        this.tokenRepo = tokenRepo;
        this.counterRepo = counterRepo;
        this.queueRepo = queueRepo;
        this.logRepo = logRepo;
    }

    @Override
    public Token issueToken(Long counterId) {

        ServiceCounter counter = counterRepo.findById(counterId)
                .orElseThrow(() -> new RuntimeException("not found"));

        if (!counter.getIsActive()) {
            throw new RuntimeException("not active");
        }

        Token token = new Token();
        token.setTokenNumber(TokenNumberGenerator.generate());
        token.setServiceCounter(counter);
        token.setStatus("WAITING");
        token.setIssuedAt(LocalDateTime.now());

        tokenRepo.save(token);

        QueuePosition qp = new QueuePosition();
        qp.setToken(token);
        qp.setPosition(1);
        qp.setUpdatedAt(LocalDateTime.now());
        queueRepo.save(qp);

        return token;
    }

    @Override
    public Token updateStatus(Long tokenId, String status) {

        Token token = tokenRepo.findById(tokenId)
                .orElseThrow(() -> new RuntimeException("not found"));

        if (token.getStatus().equals("WAITING") && status.equals("SERVING")
                || token.getStatus().equals("SERVING") && status.equals("COMPLETED")) {

            token.setStatus(status);

            if (status.equals("COMPLETED")) {
                token.setCompletedAt(LocalDateTime.now());
            }

            return tokenRepo.save(token);
        }

        throw new RuntimeException("Invalid status");
    }

    @Override
    public Token getToken(Long tokenId) {
        return tokenRepo.findById(tokenId)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}

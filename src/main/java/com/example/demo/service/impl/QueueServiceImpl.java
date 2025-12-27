package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

import java.time.LocalDateTime;

public class QueueServiceImpl {

    private final QueuePositionRepository queueRepo;
    private final TokenRepository tokenRepo;

    public QueueServiceImpl(QueuePositionRepository queueRepo, TokenRepository tokenRepo) {
        this.queueRepo = queueRepo;
        this.tokenRepo = tokenRepo;
    }

    public QueuePosition updateQueuePosition(Long tokenId, Integer newPosition) {

        if (newPosition < 1) {
            throw new IllegalArgumentException("Position must be >= 1");
        }

        Token token = tokenRepo.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));

        QueuePosition qp = queueRepo.findByToken_Id(tokenId)
                .orElse(new QueuePosition());

        qp.setToken(token);
        qp.setPosition(newPosition);
        qp.setUpdatedAt(LocalDateTime.now());

        return queueRepo.save(qp);
    }

    public QueuePosition getPosition(Long tokenId) {
        return queueRepo.findByToken_Id(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue not found"));
    }
}

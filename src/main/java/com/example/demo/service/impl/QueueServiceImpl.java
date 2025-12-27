package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class QueueServiceImpl {

    private final QueuePositionRepository queueRepo;
    private final TokenRepository tokenRepo;

    public QueueServiceImpl(QueuePositionRepository q, TokenRepository t) {
        this.queueRepo = q;
        this.tokenRepo = t;
    }

    public QueuePosition updateQueuePosition(Long tokenId, Integer pos) {
        if (pos < 1) throw new IllegalArgumentException(">= 1");

        Token t = tokenRepo.findById(tokenId).orElseThrow(() -> new RuntimeException("not found"));
        QueuePosition q = new QueuePosition();
        q.setToken(t);
        q.setPosition(pos);
        return queueRepo.save(q);
    }

    public QueuePosition getPosition(Long tokenId) {
        return queueRepo.findByToken_Id(tokenId).orElse(null);
    }
}


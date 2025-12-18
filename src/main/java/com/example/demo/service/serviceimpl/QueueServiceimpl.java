package com.example.tokenmanagement.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.tokenmanagement.exception.NotFoundException;
import com.example.tokenmanagement.model.QueuePosition;
import com.example.tokenmanagement.model.Token;
import com.example.tokenmanagement.repository.QueuePositionRepository;
import com.example.tokenmanagement.repository.TokenRepository;
import com.example.tokenmanagement.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService {

    private final QueuePositionRepository queueRepository;
    private final TokenRepository tokenRepository;

    public QueueServiceImpl(QueuePositionRepository queueRepository,
                            TokenRepository tokenRepository) {
        this.queueRepository = queueRepository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public QueuePosition updateQueuePosition(Long tokenId, Integer newPosition) {

        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new NotFoundException("Token not found"));

        QueuePosition position = queueRepository.findByToken_Id(tokenId)
                .orElse(new QueuePosition());

        position.setToken(token);
        position.setPosition(newPosition);
        position.setUpdatedAt(LocalDateTime.now());

        return queueRepository.save(position);
    }

    @Override
    public QueuePosition getPosition(Long tokenId) {
        return queueRepository.findByToken_Id(tokenId)
                .orElseThrow(() -> new NotFoundException("Queue position not found"));
    }
}

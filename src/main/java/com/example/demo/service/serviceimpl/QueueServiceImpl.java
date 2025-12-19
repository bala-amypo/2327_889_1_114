package com.example.demo.service.impl;

import com.example.demo.entity.BreachAlert;
import com.example.demo.entity.QueuePosition;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.QueueService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        if (newPosition < 1) {
            throw new IllegalArgumentException("Position must be >= 1");
        }

        BreachAlert token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));

        QueuePosition position = queueRepository.findByTokenId(tokenId)
                .orElse(new QueuePosition(token, newPosition, LocalDateTime.now()));

        position.setPosition(newPosition);
        position.setUpdatedAt(LocalDateTime.now());

        return queueRepository.save(position);
    }

    @Override
    public QueuePosition getPosition(Long tokenId) {
        return queueRepository.findByTokenId(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));
    }
}

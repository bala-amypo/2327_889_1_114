// src/main/java/com/example/demo/service/QueueService.java
package com.example.demo.service;

import com.example.demo.entity.QueuePosition;
import com.example.demo.entity.Token;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QueueService {
    private final QueuePositionRepository queuePositionRepository;
    private final TokenRepository tokenRepository;

    @Transactional
    public QueuePosition updateQueuePosition(Long tokenId, Integer newPosition) {
        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new NotFoundException("Token not found"));
        
        QueuePosition queuePosition = queuePositionRepository.findByTokenId(tokenId)
                .orElse(new QueuePosition());
        
        queuePosition.setToken(token);
        queuePosition.setPosition(newPosition);
        queuePosition.setUpdatedAt(LocalDateTime.now());
        
        return queuePositionRepository.save(queuePosition);
    }

    public Integer getPosition(Long tokenId) {
        return queuePositionRepository.findByTokenId(tokenId)
                .map(QueuePosition::getPosition)
                .orElseThrow(() -> new NotFoundException("Queue position not found"));
    }
}
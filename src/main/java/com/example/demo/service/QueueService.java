package com.example.service;

import com.example.model.QueuePosition;
import com.example.repository.QueuePositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class QueueService {
    
    @Autowired
    private QueuePositionRepository queuePositionRepository;
    
    public QueuePosition updateQueuePosition(Long tokenId, Integer newPosition) {
        QueuePosition queuePosition = new QueuePosition();
        queuePosition.setTokenId(tokenId);
        queuePosition.setPosition(newPosition);
        return queuePositionRepository.save(queuePosition);
    }
    
    public Optional<QueuePosition> getPosition(Long tokenId) {
        return queuePositionRepository.findById(tokenId);
    }
}
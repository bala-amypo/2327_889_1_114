package com.example.service.impl;

import com.example.model.QueuePosition;
import com.example.repository.QueuePositionRepository;
import com.example.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class QueueServiceImpl implements QueueService {
    
    @Autowired
    private QueuePositionRepository queuePositionRepository;
    
    @Override
    public QueuePosition updateQueuePosition(Long tokenId, Integer newPosition) {
        QueuePosition queuePosition = new QueuePosition();
        queuePosition.setTokenId(tokenId);
        queuePosition.setPosition(newPosition);
        queuePosition.setUpdatedAt(LocalDateTime.now());
        return queuePositionRepository.save(queuePosition);
    }
    
    @Override
    public Optional<QueuePosition> getPosition(Long tokenId) {
        return queuePositionRepository.findById(tokenId);
    }
}
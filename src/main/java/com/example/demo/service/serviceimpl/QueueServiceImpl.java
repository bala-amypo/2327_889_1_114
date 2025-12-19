package com.example.demo.service.impl;

import com.example.demo.entity.QueuePosition;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.service.QueueService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QueueServiceImpl implements QueueService {

    private final QueuePositionRepository repository;

    public QueueServiceImpl(QueuePositionRepository repository) {
        this.repository = repository;
    }

    @Override
    public QueuePosition updateQueuePosition(Long tokenId, Integer position) {
        QueuePosition qp = repository.findByToken_Id(tokenId)
                .orElseThrow(() -> new RuntimeException("not found"));

        qp.setPosition(position);
        qp.setUpdatedAt(LocalDateTime.now());
        return repository.save(qp);
    }

    @Override
    public QueuePosition getPosition(Long tokenId) {
        return repository.findByToken_Id(tokenId)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}

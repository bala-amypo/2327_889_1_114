
package com.example.demo.service.impl;

import com.example.demo.entity.QueuePosition;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.service.QueueService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueueServiceImpl implements QueueService {

    private final QueuePositionRepository queueRepository;

    public QueueServiceImpl(QueuePositionRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    // ================= Interface methods =================

    @Override
    public void updateQueuePosition(Long id, Integer newPosition) {
        QueuePosition qp = queueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Queue not found"));

        qp.setPosition(newPosition);
        queueRepository.save(qp);
    }

    @Override
    public QueuePosition getPosition(Long id) {
        return queueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Queue not found"));
    }

    // ================= Extra methods (NO @Override here) =================

    public QueuePosition addToQueue(QueuePosition queue) {
        return queueRepository.save(queue);
    }

    public void removeFromQueue(Long id) {
        queueRepository.deleteById(id);
    }
}

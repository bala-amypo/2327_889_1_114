
package com.example.demo.service.impl;

import com.example.demo.entity.QueuePosition;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.service.QueueService;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements QueueService {

    private final QueuePositionRepository queueRepository;

    public QueueServiceImpl(QueuePositionRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    // Must return Integer (as defined in QueueService)
    @Override
    public Integer getPosition(Long id) {
        QueuePosition qp = queueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Queue not found"));

        return qp.getPosition();   // returning INTEGER, not QueuePosition
    }

    @Override
    public void updateQueuePosition(Long id, Integer newPosition) {
        QueuePosition qp = queueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Queue not found"));

        qp.setPosition(newPosition);
        queueRepository.save(qp);
    }

    // These are extra helper methods (not in interface)
    public QueuePosition addToQueue(QueuePosition queue) {
        return queueRepository.save(queue);
    }

    public void removeFromQueue(Long id) {
        queueRepository.deleteById(id);
    }
}

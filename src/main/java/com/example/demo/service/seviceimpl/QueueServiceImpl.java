// package com.example.demo.service.impl;

// import com.example.demo.entity.QueuePosition;
// import com.example.demo.entity.Token;
// import com.example.demo.repository.QueuePositionRepository;
// import com.example.demo.repository.TokenRepository;

// public class QueueServiceImpl {

//     private final QueuePositionRepository repo;
//     private final TokenRepository tokenRepo;

//     public QueueServiceImpl(QueuePositionRepository r, TokenRepository t) {
//         this.repo = r;
//         this.tokenRepo = t;
//     }

//     public QueuePosition updateQueuePosition(Long tokenId, Integer pos) {
//         if (pos < 1) {
//             throw new IllegalArgumentException(">= 1");
//         }

//         Token t = tokenRepo.findById(tokenId).orElseThrow();
//         QueuePosition qp = new QueuePosition();
//         qp.setToken(t);
//         qp.setPosition(pos);
//         return repo.save(qp);
//     }

//     public QueuePosition getPosition(Long tokenId) {
//         return repo.findByToken_Id(tokenId).orElse(null);
//     }
// }
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

    // Add user to queue
    @Override
    public QueuePosition addToQueue(QueuePosition queue) {
        return queueRepository.save(queue);
    }

    // Update queue position
    @Override
    public QueuePosition updateQueuePosition(Long id, Integer position) {
        QueuePosition queue = queueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Queue not found"));

        queue.setPosition(position);
        return queueRepository.save(queue);
    }

    // Get current position
    @Override
    public Integer getPosition(Long id) {
        QueuePosition queue = queueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Queue not found"));

        return queue.getPosition();
    }

    // Remove from queue
    @Override
    public void removeFromQueue(Long id) {
        queueRepository.deleteById(id);
    }
}

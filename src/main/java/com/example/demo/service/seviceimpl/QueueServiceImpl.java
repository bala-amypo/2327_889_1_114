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
// 
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

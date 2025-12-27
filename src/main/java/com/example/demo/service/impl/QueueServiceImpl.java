// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;

// public class QueueServiceImpl {

//     private final QueuePositionRepository queueRepo;
//     private final TokenRepository tokenRepo;

//     public QueueServiceImpl(QueuePositionRepository q, TokenRepository t) {
//         this.queueRepo = q;
//         this.tokenRepo = t;
//     }

//     public QueuePosition updateQueuePosition(Long tokenId, Integer pos) {
//         if (pos < 1) throw new IllegalArgumentException(">= 1");

//         Token t = tokenRepo.findById(tokenId).orElseThrow(() -> new RuntimeException("not found"));
//         QueuePosition q = new QueuePosition();
//         q.setToken(t);
//         q.setPosition(pos);
//         return queueRepo.save(q);
//     }

//     public QueuePosition getPosition(Long tokenId) {
//         return queueRepo.findByToken_Id(tokenId).orElse(null);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.QueuePosition;
import com.example.demo.entity.Token;
import com.example.demo.repository.QueuePositionRepository;
import com.example.demo.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QueueServiceImpl {
    private final QueuePositionRepository queueRepo;
    private final TokenRepository tokenRepository;

    public QueueServiceImpl(QueuePositionRepository queueRepo, TokenRepository tokenRepository) {
        this.queueRepo = queueRepo;
        this.tokenRepository = tokenRepository;
    }

    public QueuePosition updateQueuePosition(Long tokenId, Integer newPosition) {
        if (newPosition < 1) {
            throw new IllegalArgumentException("Position must be >= 1");
        }

        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new RuntimeException("Token not found"));

        QueuePosition queuePosition = queueRepo.findByToken_Id(tokenId)
                .orElse(new QueuePosition());
        
        queuePosition.setToken(token);
        queuePosition.setPosition(newPosition);
        queuePosition.setUpdatedAt(LocalDateTime.now());
        
        return queueRepo.save(queuePosition);
    }

    public QueuePosition getPosition(Long tokenId) {
        return queueRepo.findByToken_Id(tokenId)
                .orElseThrow(() -> new RuntimeException("Queue position not found"));
    }
}

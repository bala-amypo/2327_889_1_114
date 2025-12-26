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

import com.example.demo.entity.Token;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.QueueService;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements QueueService {

    private final TokenRepository tokenRepository;

    public QueueServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Integer getPosition(Long tokenId) {
        return tokenRepository.findById(tokenId)
                .orElseThrow()
                .getQueuePosition();
    }

    @Override
    public void updatePosition(Long tokenId, Integer newPosition) {
        if (newPosition <= 0) {
            throw new IllegalArgumentException("Invalid position");
        }

        Token token = tokenRepository.findById(tokenId).orElseThrow();
        token.setQueuePosition(newPosition);
        tokenRepository.save(token);
    }
}

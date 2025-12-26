// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.UUID;

// public class TokenServiceImpl {

//     private final TokenRepository tokenRepo;
//     private final ServiceCounterRepository counterRepo;
//     private final TokenLogRepository logRepo;
//     private final QueuePositionRepository queueRepo;

//     public TokenServiceImpl(TokenRepository t, ServiceCounterRepository c, TokenLogRepository l, QueuePositionRepository q) {
//         this.tokenRepo = t;
//         this.counterRepo = c;
//         this.logRepo = l;
//         this.queueRepo = q;
//     }

//     public Token issueToken(Long counterId) {
//         ServiceCounter sc = counterRepo.findById(counterId)
//                 .orElseThrow(() -> new RuntimeException("not found"));

//         if (!sc.getIsActive()) {
//             throw new IllegalArgumentException("not active");
//         }

//         Token token = new Token();
//         token.setServiceCounter(sc);
//         token.setStatus("WAITING");
//         token.setTokenNumber(UUID.randomUUID().toString());

//         tokenRepo.save(token);

//         List<Token> waiting = tokenRepo.findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(counterId, "WAITING");

//         QueuePosition qp = new QueuePosition();
//         qp.setToken(token);
//         qp.setPosition(waiting.size());
//         queueRepo.save(qp);

//         TokenLog log = new TokenLog();
//         log.setToken(token);
//         log.setLogMessage("Token issued");
//         logRepo.save(log);

//         return token;
//     }

//     public Token updateStatus(Long tokenId, String status) {
//         Token token = tokenRepo.findById(tokenId)
//                 .orElseThrow(() -> new RuntimeException("not found"));

//         if (token.getStatus().equals("WAITING") && status.equals("COMPLETED")) {
//             throw new IllegalArgumentException("Invalid status");
//         }

//         token.setStatus(status);
//         token.setCompletedAt(LocalDateTime.now());
//         tokenRepo.save(token);

//         TokenLog log = new TokenLog();
//         log.setToken(token);
//         log.setLogMessage("Status updated");
//         logRepo.save(log);

//         return token;
//     }

//     public Token getToken(Long tokenId) {
//         return tokenRepo.findById(tokenId)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenServiceImpl {

    private final TokenRepository tokenRepo;

    public TokenServiceImpl(TokenRepository tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    // Used by TokenController
    public Token issueToken(Long counterId) {
        Token token = new Token();
        token.setStatus(TokenStatus.WAITING);
        token.setIssuedAt(LocalDateTime.now());
        token.setTokenNumber("T" + System.currentTimeMillis());
        return tokenRepo.save(token);
    }

    public Token updateStatus(Long tokenId, String status) {
        Token token = tokenRepo.findById(tokenId).orElseThrow();
        token.setStatus(TokenStatus.valueOf(status));
        if (token.getStatus() == TokenStatus.COMPLETED) {
            token.setCompletedAt(LocalDateTime.now());
        }
        return tokenRepo.save(token);
    }

    public Token getToken(Long counterId) {
        return tokenRepo.findFirstByServiceCounter_IdAndStatusOrderByIssuedAtAsc(
                counterId, TokenStatus.WAITING
        );
    }
}

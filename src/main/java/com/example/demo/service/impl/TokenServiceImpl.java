// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;

// import java.time.LocalDateTime;
// import java.util.*;

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
//         ServiceCounter sc = counterRepo.findById(counterId).orElseThrow(() -> new RuntimeException("not found"));
//         if (!sc.getIsActive()) throw new IllegalArgumentException("not active");

//         Token t = new Token();
//         t.setServiceCounter(sc);
//         t.setTokenNumber(UUID.randomUUID().toString());
//         t.setStatus("WAITING");

//         tokenRepo.save(t);

//         QueuePosition q = new QueuePosition();
//         q.setToken(t);
//         q.setPosition(tokenRepo.findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(counterId, "WAITING").size() + 1);
//         queueRepo.save(q);

//         logRepo.save(new TokenLog(){{
//             setToken(t);
//             setLogMessage("issued");
//         }});

//         return t;
//     }

//     public Token updateStatus(Long tokenId, String status) {
//         Token t = tokenRepo.findById(tokenId).orElseThrow(() -> new RuntimeException("not found"));

//         if (t.getStatus().equals("WAITING") && status.equals("COMPLETED"))
//             throw new IllegalArgumentException("Invalid status");

//         t.setStatus(status);
//         if (status.equals("COMPLETED") || status.equals("CANCELLED"))
//             t.setCompletedAt(LocalDateTime.now());

//         tokenRepo.save(t);
//         logRepo.save(new TokenLog(){{ setToken(t); setLogMessage(status); }});

//         return t;
//     }

//     public Token getToken(Long id) {
//         return tokenRepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.ServiceCounter;
import com.example.demo.entity.Token;
import com.example.demo.entity.TokenLog;
import com.example.demo.entity.QueuePosition;
import com.example.demo.repository.ServiceCounterRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.TokenLogRepository;
import com.example.demo.repository.QueuePositionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TokenServiceImpl {
    private final TokenRepository tokenRepository;
    private final ServiceCounterRepository counterRepository;
    private final TokenLogRepository logRepo;
    private final QueuePositionRepository queueRepo;

    public TokenServiceImpl(TokenRepository tokenRepository, 
                           ServiceCounterRepository counterRepository,
                           TokenLogRepository logRepo,
                           QueuePositionRepository queueRepo) {
        this.tokenRepository = tokenRepository;
        this.counterRepository = counterRepository;
        this.logRepo = logRepo;
        this.queueRepo = queueRepo;
    }

    public Token issueToken(Long counterId) {
        ServiceCounter counter = counterRepository.findById(counterId)
                .orElseThrow(() -> new RuntimeException("Counter not found"));
        
        if (!counter.getIsActive()) {
            throw new IllegalArgumentException("Counter is not active");
        }

        Token token = new Token();
        token.setTokenNumber(generateTokenNumber());
        token.setServiceCounter(counter);
        token.setStatus("WAITING");
        token.setIssuedAt(LocalDateTime.now());
        
        Token saved = tokenRepository.save(token);
        
        // Create queue position
        List<Token> waitingTokens = tokenRepository.findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(counterId, "WAITING");
        QueuePosition queuePosition = new QueuePosition();
        queuePosition.setToken(saved);
        queuePosition.setPosition(waitingTokens.size());
        queuePosition.setUpdatedAt(LocalDateTime.now());
        queueRepo.save(queuePosition);
        
        // Create log entry
        TokenLog log = new TokenLog();
        log.setToken(saved);
        log.setLogMessage("Token issued");
        logRepo.save(log);
        
        return saved;
    }

    public Token updateStatus(Long tokenId, String newStatus) {
        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new RuntimeException("Token not found"));
        
        String currentStatus = token.getStatus();
        
        // Validate status transitions
        if (!isValidTransition(currentStatus, newStatus)) {
            throw new IllegalArgumentException("Invalid status transition from " + currentStatus + " to " + newStatus);
        }
        
        token.setStatus(newStatus);
        
        if ("COMPLETED".equals(newStatus) || "CANCELLED".equals(newStatus)) {
            token.setCompletedAt(LocalDateTime.now());
        }
        
        Token saved = tokenRepository.save(token);
        
        // Create log entry
        TokenLog log = new TokenLog();
        log.setToken(saved);
        log.setLogMessage("Status updated to " + newStatus);
        logRepo.save(log);
        
        return saved;
    }

    public Token getToken(Long tokenId) {
        return tokenRepository.findById(tokenId)
                .orElseThrow(() -> new RuntimeException("Token not found"));
    }

    private boolean isValidTransition(String from, String to) {
        if ("WAITING".equals(from)) {
            return "SERVING".equals(to) || "CANCELLED".equals(to);
        }
        if ("SERVING".equals(from)) {
            return "COMPLETED".equals(to) || "CANCELLED".equals(to);
        }
        return false;
    }

    private String generateTokenNumber() {
        return "T-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}

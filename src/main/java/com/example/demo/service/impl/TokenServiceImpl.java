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

import com.example.demo.entity.Token;
import com.example.demo.entity.TokenStatus;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token updateStatus(Long tokenId, TokenStatus status) {
        Token token = tokenRepository.findById(tokenId).orElseThrow();

        token.setStatus(status);

        // ✅ When COMPLETED → set servedAt
        if (status == TokenStatus.COMPLETED) {
            token.setServedAt(LocalDateTime.now());
        }

        // ✅ When CANCELLED → reorder queue
        if (status == TokenStatus.CANCELLED) {
            List<Token> tokens = tokenRepository.findAll();
            int pos = 1;

            for (Token t : tokens) {
                if (t.getStatus() != TokenStatus.CANCELLED) {
                    t.setQueuePosition(pos++);
                    tokenRepository.save(t);
                }
            }
        }

        return tokenRepository.save(token);
    }
}

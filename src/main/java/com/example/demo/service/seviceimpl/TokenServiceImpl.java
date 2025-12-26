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

import com.example.demo.entity.Token;
import com.example.demo.entity.TokenStatus;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token createToken(Token token) {
        token.setStatus(TokenStatus.WAITING);
        token.setIssuedAt(LocalDateTime.now());
        return tokenRepository.save(token);
    }

    @Override
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }
}

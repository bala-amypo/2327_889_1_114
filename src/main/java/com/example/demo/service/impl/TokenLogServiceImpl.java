// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;
// import java.util.List;

// public class TokenLogServiceImpl {

//     private final TokenLogRepository logRepo;
//     private final TokenRepository tokenRepo;

//     public TokenLogServiceImpl(TokenLogRepository l, TokenRepository t) {
//         this.logRepo = l;
//         this.tokenRepo = t;
//     }

//     public TokenLog addLog(Long tokenId, String msg) {
//         Token t = tokenRepo.findById(tokenId).orElseThrow();
//         TokenLog l = new TokenLog();
//         l.setToken(t);
//         l.setLogMessage(msg);
//         return logRepo.save(l);
//     }

//     public List<TokenLog> getLogs(Long tokenId) {
//         return logRepo.findByToken_IdOrderByLoggedAtAsc(tokenId);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.Token;
import com.example.demo.entity.TokenLog;
import com.example.demo.repository.TokenLogRepository;
import com.example.demo.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenLogServiceImpl {
    private final TokenLogRepository logRepo;
    private final TokenRepository tokenRepository;

    public TokenLogServiceImpl(TokenLogRepository logRepo, TokenRepository tokenRepository) {
        this.logRepo = logRepo;
        this.tokenRepository = tokenRepository;
    }

    public TokenLog addLog(Long tokenId, String message) {
        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new RuntimeException("Token not found"));

        TokenLog log = new TokenLog();
        log.setToken(token);
        log.setLogMessage(message);
        log.setLoggedAt(LocalDateTime.now());
        
        return logRepo.save(log);
    }

    public List<TokenLog> getLogs(Long tokenId) {
        return logRepo.findByToken_IdOrderByLoggedAtAsc(tokenId);
    }
}
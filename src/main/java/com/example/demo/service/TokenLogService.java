// src/main/java/com/example/demo/service/TokenLogService.java
package com.example.demo.service;

import com.example.demo.entity.Token;
import com.example.demo.entity.TokenLog;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.TokenLogRepository;
import com.example.demo.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenLogService {
    private final TokenLogRepository tokenLogRepository;
    private final TokenRepository tokenRepository;

    public TokenLog addLog(Long tokenId, String message) {
        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new NotFoundException("Token not found"));
        
        TokenLog log = new TokenLog();
        log.setToken(token);
        log.setLogMessage(message);
        log.setLoggedAt(LocalDateTime.now());
        
        return tokenLogRepository.save(log);
    }

    public List<TokenLog> getLogs(Long tokenId) {
        return tokenLogRepository.findByTokenIdOrderByLoggedAtAsc(tokenId);
    }
}
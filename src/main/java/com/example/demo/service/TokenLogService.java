package com.example.service;

import com.example.model.TokenLog;
import com.example.repository.TokenLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenLogService {
    
    @Autowired
    private TokenLogRepository tokenLogRepository;
    
    public TokenLog addLog(Long tokenId, String message) {
        TokenLog log = new TokenLog();
        log.setTokenId(tokenId);
        log.setMessage(message);
        log.setTimestamp(LocalDateTime.now());
        return tokenLogRepository.save(log);
    }
    
    public List<TokenLog> getLogs(Long tokenId) {
        return tokenLogRepository.findByTokenId(tokenId);
    }
}
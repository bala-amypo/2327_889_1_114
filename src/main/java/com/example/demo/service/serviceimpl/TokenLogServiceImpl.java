package com.example.service.impl;

import com.example.model.TokenLog;
import com.example.repository.TokenLogRepository;
import com.example.service.TokenLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TokenLogServiceImpl implements TokenLogService {
    
    @Autowired
    private TokenLogRepository tokenLogRepository;
    
    @Override
    public TokenLog addLog(Long tokenId, String message) {
        TokenLog log = new TokenLog();
        log.setTokenId(tokenId);
        log.setMessage(message);
        log.setTimestamp(LocalDateTime.now());
        return tokenLogRepository.save(log);
    }
    
    @Override
    public List<TokenLog> getLogs(Long tokenId) {
        return tokenLogRepository.findByTokenId(tokenId);
    }
}
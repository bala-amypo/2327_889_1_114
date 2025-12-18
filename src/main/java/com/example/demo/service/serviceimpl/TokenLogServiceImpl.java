package com.example.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.exception.NotFoundException;
import com.example.demo.model.Token;
import com.example.demo.model.TokenLog;
import com.example.demo.model.repository.TokenLogRepository;
import com.example.demo.model.repository.TokenRepository;
import com.example.demo.model.service.TokenLogService;

@Service
public class TokenLogServiceImpl implements TokenLogService {

    private final TokenLogRepository logRepository;
    private final TokenRepository tokenRepository;

    public TokenLogServiceImpl(TokenLogRepository logRepository,
                               TokenRepository tokenRepository) {
        this.logRepository = logRepository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void addLog(Long tokenId, String message) {

        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() -> new NotFoundException("Token not found"));

        TokenLog log = new TokenLog();
        log.setToken(token);
        log.setLogMessage(message);
        log.setLoggedAt(LocalDateTime.now());

        logRepository.save(log);
    }

    @Override
    public List<TokenLog> getLogs(Long tokenId) {
        return logRepository.findByToken_IdOrderByLoggedAtAsc(tokenId);
    }
}

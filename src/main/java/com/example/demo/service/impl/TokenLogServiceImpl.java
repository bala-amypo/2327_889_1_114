package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

import java.time.LocalDateTime;
import java.util.List;

public class TokenLogServiceImpl {

    private final TokenLogRepository logRepo;
    private final TokenRepository tokenRepo;

    public TokenLogServiceImpl(TokenLogRepository logRepo, TokenRepository tokenRepo) {
        this.logRepo = logRepo;
        this.tokenRepo = tokenRepo;
    }

    public TokenLog addLog(Long tokenId, String message) {

        Token token = tokenRepo.findById(tokenId)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found"));

        TokenLog log = new TokenLog(token, message, LocalDateTime.now());
        return logRepo.save(log);
    }

    public List<TokenLog> getLogs(Long tokenId) {
        return logRepo.findByToken_IdOrderByLoggedAtAsc(tokenId);
    }
}

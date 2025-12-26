package com.example.demo.service.impl;

import com.example.demo.entity.Token;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenIssueService;
import org.springframework.stereotype.Service;

@Service
public class TokenIssueServiceImpl implements TokenIssueService {

    private final TokenRepository tokenRepository;

    public TokenIssueServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token issue(Token token) {
        long count = tokenRepository.count();
        token.setTokenNumber((int) count + 1);
        return tokenRepository.save(token);
    }
}

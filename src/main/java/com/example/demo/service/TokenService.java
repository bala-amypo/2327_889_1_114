package com.example.tokenmanagement.service;

import com.example.demo.tokenmanagement.model.Token;

public interface TokenService {

    Token issueToken(Long counterId);

    Token updateStatus(Long tokenId, String status);

    Token getToken(Long tokenId);
}

package com.example.tokenmanagement.service;

import java.util.List;

import com.example.tokenmanagement.model.TokenLog;

public interface TokenLogService {

    void addLog(Long tokenId, String message);

    List<TokenLog> getLogs(Long tokenId);
}

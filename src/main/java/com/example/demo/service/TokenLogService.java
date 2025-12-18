package com.example.service;

import java.util.List;

import com.example.demo.model.TokenLog;

public interface TokenLogService {

    void addLog(Long tokenId, String message);

    List<TokenLog> getLogs(Long tokenId);
}

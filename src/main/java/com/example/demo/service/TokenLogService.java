package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;

// TokenLogService.java
interface TokenLogService {
    TokenLog addLog(Long tokenId, String message);
    List<TokenLog> getLogs(Long tokenId);
    List<TokenLog> getLogsByTokenNumber(String tokenNumber);
}
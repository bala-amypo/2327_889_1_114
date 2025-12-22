package com.example.demo.controller;

import com.example.demo.dto.TokenLogResponse;
import com.example.demo.entity.TokenLog;
import com.example.demo.service.TokenLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logs")
public class TokenLogController {

    private final TokenLogService tokenLogService;

    public TokenLogController(TokenLogService tokenLogService) {
        this.tokenLogService = tokenLogService;
    }

    @PostMapping("/{tokenId}")
    public TokenLog add(@PathVariable Long tokenId,
                        @RequestParam String message) {
        return tokenLogService.addLog(tokenId, message);
    }

    @GetMapping("/{tokenId}")
    public List<TokenLogResponse> getLogs(@PathVariable Long tokenId) {

        return tokenLogService.getLogs(tokenId)
                .stream()
                .map(l -> new TokenLogResponse(
                        l.getId(),
                        l.getToken().getTokenNumber(),
                        l.getLogMessage(),
                        l.getLoggedAt()))
                .collect(Collectors.toList());
    }
}

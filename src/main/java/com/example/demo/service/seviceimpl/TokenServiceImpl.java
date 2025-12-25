package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.TokenService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepo;
    private final ServiceCounterRepository counterRepo;
    private final TokenLogRepository logRepo;
    private final QueuePositionRepository queueRepo;

    public TokenServiceImpl(TokenRepository t, ServiceCounterRepository c,
                            TokenLogRepository l, QueuePositionRepository q) {
        this.tokenRepo = t;
        this.counterRepo = c;
        this.logRepo = l;
        this.queueRepo = q;
    }

    public Token issueToken(Long counterId) {
        ServiceCounter c = counterRepo.findById(counterId)
                .orElseThrow(() -> new RuntimeException("not found"));

        if (!c.getIsActive())
            throw new IllegalArgumentException("not active");

        Token t = new Token();
        t.setServiceCounter(c);
        t.setTokenNumber("T-" + System.currentTimeMillis());
        t.setStatus("WAITING");
        tokenRepo.save(t);

        int pos = tokenRepo.findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(counterId,"WAITING").size();

        QueuePosition qp = new QueuePosition();
        qp.setToken(t);
        qp.setPosition(pos);
        queueRepo.save(qp);

        TokenLog log = new TokenLog();
        log.setToken(t);
        log.setMessage("Issued");
        logRepo.save(log);

        return t;
    }

    public Token updateStatus(Long id, String newStatus) {
        Token t = tokenRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        if (t.getStatus().equals("WAITING") && newStatus.equals("COMPLETED"))
            throw new IllegalArgumentException("Invalid status");

        t.setStatus(newStatus);

        if (newStatus.equals("COMPLETED") || newStatus.equals("CANCELLED"))
            t.setCompletedAt(LocalDateTime.now());

        tokenRepo.save(t);

        TokenLog log = new TokenLog();
        log.setToken(t);
        log.setMessage("Status " + newStatus);
        logRepo.save(log);

        return t;
    }

    public Token getToken(Long id) {
        return tokenRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}

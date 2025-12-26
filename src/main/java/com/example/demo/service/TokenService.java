// package com.example.demo.service;

// import com.example.demo.entity.Token;

// public interface TokenService {
//     Token issueToken(Long counterId);
//     Token updateStatus(Long tokenId, String status);
//     Token getToken(Long tokenId);
// }
package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.TokenRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TokenService {

    private final TokenRepository repo;
    private int counter = 1;

    public TokenService(TokenRepository repo) {
        this.repo = repo;
    }

    public Token issueToken() {
        Token t = new Token();
        t.setNumber(counter++);
        t.setStatus(TokenStatus.WAITING);
        return repo.save(t);            // t66
    }

    public Token markServing(Long id) {
        Token t = repo.findById(id).orElseThrow();
        t.setStatus(TokenStatus.SERVING);     // t15
        return repo.save(t);
    }

    public Token markCompleted(Long id) {
        Token t = repo.findById(id).orElseThrow();
        t.setStatus(TokenStatus.COMPLETED);
        t.setCompletedAt(LocalDateTime.now()); // t16
        return repo.save(t);
    }

    public Token cancel(Long id) {
        Token t = repo.findById(id).orElseThrow();
        t.setStatus(TokenStatus.CANCELLED);    // t69
        return repo.save(t);
    }
}

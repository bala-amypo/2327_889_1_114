// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;
// import java.util.List;

// public class TokenLogServiceImpl {

//     private final TokenLogRepository logRepo;
//     private final TokenRepository tokenRepo;

//     public TokenLogServiceImpl(TokenLogRepository l, TokenRepository t) {
//         this.logRepo = l;
//         this.tokenRepo = t;
//     }

//     public TokenLog addLog(Long tokenId, String msg) {
//         Token t = tokenRepo.findById(tokenId).orElseThrow();
//         TokenLog l = new TokenLog();
//         l.setToken(t);
//         l.setLogMessage(msg);
//         return logRepo.save(l);
//     }

//     public List<TokenLog> getLogs(Long tokenId) {
//         return logRepo.findByToken_IdOrderByLoggedAtAsc(tokenId);
//     }
// }
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

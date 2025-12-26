// package com.example.demo.service.impl;

// import com.example.demo.entity.Token;
// import com.example.demo.entity.User;
// import com.example.demo.repository.TokenRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.TokenIssueService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;

// @Service
// public class TokenIssueServiceImpl implements TokenIssueService {

//     @Autowired
//     private TokenRepository tokenRepository;

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public Token issueToken(Long userId) {

//         User user = userRepository.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         Token token = new Token();
//         token.setUser(user);
//         token.setIssuedTime(LocalDateTime.now());
//         token.setStatus("ISSUED");

//         return tokenRepository.save(token);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.Token;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.TokenIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenIssueServiceImpl implements TokenIssueService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token issue(Token token) {
        return tokenRepository.save(token);
    }
}


package com.example.demo.service;

import com.example.demo.entity.Token;
import java.util.List;

public interface TokenService {
    Token createToken(Token token);
    Token getToken(Long id);
    List<Token> getAllTokens();
}

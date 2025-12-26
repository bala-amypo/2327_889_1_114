
package com.example.demo.config;

import com.example.demo.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    // Generate token for user
    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        // Using HMAC SHA key
        return Jwts.builder()
                .setSubject(Long.toString(user.getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)  // fixed
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token); // fixed
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get user id from token
    public Long getUserIdFromToken(String token) {
        return Long.parseLong(Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }
}


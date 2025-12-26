// package com.example.demo.config;

// import io.jsonwebtoken.*;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// public class JwtTokenProvider {

//     private final String secretKey;
//     private final long validityInMs;

//     public JwtTokenProvider(String secretKey, long validityInMs) {
//         this.secretKey = secretKey;
//         this.validityInMs = validityInMs;
//     }

//     public String generateToken(Long userId, String email, String role) {

//         Map<String, Object> claims = new HashMap<>();
//         claims.put("email", email);
//         claims.put("role", role);

//         return Jwts.builder()
//                 // .setClaims(claims)
//                 .setSubject(String.valueOf(userId))
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser()
//                     .setSigningKey(secretKey)
//                     .parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public Claims getClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secretKey)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
package com.example.demo.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Key key;
    private final long expiryMs;

    // Constructor with secret + expiry
    public JwtTokenProvider(String secret, int expiryMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiryMs = expiryMs;
    }

    // Default constructor for Spring
    public JwtTokenProvider() {
        this.key = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey".getBytes());
        this.expiryMs = 86400000; // 1 day
    }

    // Method used by AuthController
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("id", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiryMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}


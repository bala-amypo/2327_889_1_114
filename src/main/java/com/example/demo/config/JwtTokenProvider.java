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
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String secretKey; // your secret key
    private final long validityInMilliseconds; // token validity in ms

    // Default constructor
    public JwtTokenProvider() {
        this.secretKey = "mySecretKey12345678901234567890"; // minimum 256 bits for HS256
        this.validityInMilliseconds = 3600000; // 1 hour
    }

    // Generate token from User object
    public String generateToken(com.example.demo.entity.User user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(user.getName())       // <-- FIXED getter, replace with your correct getter
                .claim("id", user.getId())        // replace with your getter
                .claim("email", user.getEmail())  // replace with your getter
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // old jjwt 0.9.x style
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // Get username from token
    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Get user ID from token
    public Long getUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();
        return claims.get("id", Long.class);
    }

    // Get email from token
    public String getEmail(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();
        return claims.get("email", String.class);
    }
}


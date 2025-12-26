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
import io.jsonwebtoken.*;
import java.util.Date;
import java.security.Key;
import io.jsonwebtoken.security.Keys;
import com.example.demo.entity.User;

public class JwtTokenProvider {

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(User user) {
        return Jwts.builder()
            .setSubject(user.getEmail())
            .setIssuedAt(new Date())
            .signWith(key)
            .compact();
    }

    public Jws<Claims> getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }
}


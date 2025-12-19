// src/main/java/com/example/demo/util/TokenNumberGenerator.java
package com.example.demo.util;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class TokenNumberGenerator {
    
    public String generateTokenNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        int random = ThreadLocalRandom.current().nextInt(100, 1000);
        return "TKN" + timestamp + random;
    }
}
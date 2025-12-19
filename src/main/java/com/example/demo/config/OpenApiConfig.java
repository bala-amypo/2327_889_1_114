// src/main/java/com/example/demo/config/OpenApiConfig.java
package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Digital Queue Management System API")
                        .version("1.0")
                        .description("API for managing queues, tokens, and service counters"));
    }
}
package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// TokenLogRepository.java
@Repository
interface TokenLogRepository extends JpaRepository<TokenLog, Long> {
    List<TokenLog> findByTokenIdOrderByLoggedAtAsc(Long tokenId);
    List<TokenLog> findByToken_TokenNumberOrderByLoggedAtAsc(String tokenNumber);
}


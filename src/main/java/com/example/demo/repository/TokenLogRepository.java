package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface TokenLogRepository extends JpaRepository<TokenLog, Long> {
    List<TokenLog> findByTokenIdOrderByLoggedAtAsc(Long tokenId);
}

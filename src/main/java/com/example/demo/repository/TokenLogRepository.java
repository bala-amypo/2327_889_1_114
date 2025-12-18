package com.example.demo.tokenmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tokenmanagement.model.TokenLog;

public interface TokenLogRepository extends JpaRepository<TokenLog, Long> {

    List<TokenLog> findByToken_IdOrderByLoggedAtAsc(Long tokenId);
}

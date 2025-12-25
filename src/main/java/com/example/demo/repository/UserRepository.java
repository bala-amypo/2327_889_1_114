package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

public interface ServiceCounterRepository extends JpaRepository<ServiceCounter, Long> {
    List<ServiceCounter> findByIsActiveTrue();
}

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByTokenNumber(String tokenNumber);
    List<Token> findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(Long counterId, String status);
}

public interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {
    Optional<QueuePosition> findByToken_Id(Long tokenId);
}

public interface TokenLogRepository extends JpaRepository<TokenLog, Long> {
    List<TokenLog> findByToken_IdOrderByLoggedAtAsc(Long tokenId);
}

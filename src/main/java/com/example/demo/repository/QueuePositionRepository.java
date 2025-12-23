package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// QueuePositionRepository.java
@Repository
interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {
    Optional<QueuePosition> findByTokenId(Long tokenId);
    Optional<QueuePosition> findByToken_TokenNumber(String tokenNumber);
}

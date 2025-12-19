package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {
    Optional<QueuePosition> findByTokenId(Long tokenId);
}

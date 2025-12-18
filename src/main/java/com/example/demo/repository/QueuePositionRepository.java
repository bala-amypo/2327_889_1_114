package com.example.demo.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.QueuePosition;

public interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {

    Optional<QueuePosition> findByToken_Id(Long tokenId);
}

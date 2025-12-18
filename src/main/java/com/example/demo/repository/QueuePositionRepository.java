package com.example.demo.tokenmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tokenmanagement.model.QueuePosition;

public interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {

    Optional<QueuePosition> findByToken_Id(Long tokenId);
}

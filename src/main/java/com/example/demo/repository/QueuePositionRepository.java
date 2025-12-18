package com.example.repository;

import com.example.model.QueuePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {
}
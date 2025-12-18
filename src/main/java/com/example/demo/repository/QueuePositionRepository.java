package com.example.queue.repository;

import com.example.queue.model.QueuePosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {
    List<QueuePosition> findByToken_Id(Long tokenId);
}

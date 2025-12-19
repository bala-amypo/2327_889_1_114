package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo.entity.*;
public interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {
Optional<QueuePosition> findByToken_Id(Long tokenId);
}
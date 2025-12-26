
package com.example.demo.repository;

import com.example.demo.entity.QueuePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueuePositionRepository extends JpaRepository<QueuePosition, Long> {
}


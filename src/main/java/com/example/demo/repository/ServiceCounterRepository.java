package com.example.repository;

import com.example.model.ServiceCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceCounterRepository extends JpaRepository<ServiceCounter, Long> {
    @Query("SELECT sc FROM ServiceCounter sc WHERE sc.isActive = true")
    List<ServiceCounter> findActiveCounters();
}
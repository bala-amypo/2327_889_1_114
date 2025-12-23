package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
interface BreachAlertRepository extends JpaRepository<BreachAlert, Long> {
    Optional<BreachAlert> findByTokenNumber(String tokenNumber);
    boolean existsByTokenNumber(String tokenNumber);
    List<BreachAlert> findByStatus(String status);
    List<BreachAlert> findByColdRoomIdOrderByIssuedAtDesc(Long coldRoomId);
    List<BreachAlert> findByStatusOrderByIssuedAtAsc(String status);
}

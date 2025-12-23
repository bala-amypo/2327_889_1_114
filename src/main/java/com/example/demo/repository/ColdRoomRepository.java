package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;



// ColdRoomRepository.java
@Repository
interface ColdRoomRepository extends JpaRepository<ColdRoom, Long> {
    Optional<ColdRoom> findByName(String name);
    List<ColdRoom> findByLocation(String location);
}


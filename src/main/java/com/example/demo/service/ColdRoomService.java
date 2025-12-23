package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;

// ColdRoomService.java
interface ColdRoomService {
    ColdRoom createColdRoom(ColdRoom coldRoom);
    ColdRoom getColdRoomById(Long id);
    List<ColdRoom> getAllColdRooms();
    ColdRoom updateColdRoom(Long id, ColdRoom coldRoom);
    void deleteColdRoom(Long id);
}


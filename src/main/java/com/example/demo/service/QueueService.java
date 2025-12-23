package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;



// QueueService.java
interface QueueService {
    QueuePosition updateQueuePosition(Long tokenId, Integer newPosition);
    QueuePosition getPosition(Long tokenId);
    QueuePosition getPositionByTokenNumber(String tokenNumber);
}


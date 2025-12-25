package com.example.demo.service;

import com.example.demo.entity.QueuePosition;

public interface QueueService {
    QueuePosition updateQueuePosition(Long tokenId, Integer pos);
    QueuePosition getPosition(Long tokenId);
}

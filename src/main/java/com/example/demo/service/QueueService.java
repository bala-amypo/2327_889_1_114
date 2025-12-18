package com.example.tokenmanagement.service;

import com.example.tokenmanagement.model.QueuePosition;

public interface QueueService {

    QueuePosition updateQueuePosition(Long tokenId, Integer newPosition);

    QueuePosition getPosition(Long tokenId);
}

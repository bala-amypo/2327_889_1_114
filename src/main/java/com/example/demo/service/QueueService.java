package com.example.demo.service;

import com.example.demo.entity.QueuePosition;
import java.util.List;

public interface QueueService {
    QueuePosition addToQueue(Long tokenId);
    List<QueuePosition> getQueue();
}


package com.example.demo.service;

public interface QueueService {
    void updateQueuePosition(Long id, Integer position);
    Integer getPosition(Long id);
}

// package com.example.demo.service;

// import com.example.demo.entity.QueuePosition;

// public interface QueueService {
//     QueuePosition updateQueuePosition(Long tokenId, Integer position);
//     QueuePosition getPosition(Long tokenId);
// }
package com.example.demo.service;

public interface QueueService {
    Integer getPosition(Long tokenId);
    void updateQueuePosition(Long tokenId, Integer newPosition);
}

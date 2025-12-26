// package com.example.demo.service;

// import com.example.demo.entity.QueuePosition;

// public interface QueueService {
//     QueuePosition updateQueuePosition(Long tokenId, Integer position);
//     QueuePosition getPosition(Long tokenId);
// }
package com.example.demo.service;

public interface QueueService {
    void updateQueuePosition(Long id, Integer position);
    Integer getPosition(Long id);
}

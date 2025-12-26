
// package com.example.demo.service;

// public interface QueueService {
//     void updateQueuePosition(Long id, Integer position);
//     Integer getPosition(Long id);
// }
package com.example.demo.service;

public interface QueueService {

    void updateQueuePosition(Long tokenId, Integer newPosition);

    // Add other method signatures if needed
}

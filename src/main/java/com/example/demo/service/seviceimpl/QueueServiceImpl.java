// package com.example.demo.service.impl;

// import com.example.demo.entity.QueuePosition;
// import com.example.demo.entity.Token;
// import com.example.demo.repository.QueuePositionRepository;
// import com.example.demo.repository.TokenRepository;

// public class QueueServiceImpl {

//     private final QueuePositionRepository repo;
//     private final TokenRepository tokenRepo;

//     public QueueServiceImpl(QueuePositionRepository r, TokenRepository t) {
//         this.repo = r;
//         this.tokenRepo = t;
//     }

//     public QueuePosition updateQueuePosition(Long tokenId, Integer pos) {
//         if (pos < 1) {
//             throw new IllegalArgumentException(">= 1");
//         }

//         Token t = tokenRepo.findById(tokenId).orElseThrow();
//         QueuePosition qp = new QueuePosition();
//         qp.setToken(t);
//         qp.setPosition(pos);
//         return repo.save(qp);
//     }

//     public QueuePosition getPosition(Long tokenId) {
//         return repo.findByToken_Id(tokenId).orElse(null);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.QueuePosition;
import com.example.demo.repository.QueueRepository;
import com.example.demo.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueRepository queueRepository;

    // Update position of a queue entry
    @Override
    public void updateQueuePosition(Long id, Integer position) {
        Optional<QueuePosition> queueOpt = queueRepository.findById(id);
        if (queueOpt.isPresent()) {
            QueuePosition queue = queueOpt.get();
            queue.setPosition(position);
            queueRepository.save(queue);
        }
    }

    // Get position of a queue entry
    @Override
    public Integer getPosition(Long id) {
        Optional<QueuePosition> queueOpt = queueRepository.findById(id);
        return queueOpt.map(QueuePosition::getPosition).orElse(null);
    }
}

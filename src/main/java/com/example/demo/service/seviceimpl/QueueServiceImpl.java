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

import com.example.demo.service.QueueService;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements QueueService {

    @Override
    public Integer getPosition(Long tokenId) {
        // implement your logic
        return 1;
    }

    @Override
    public void updateQueuePosition(Long tokenId, Integer newPosition) {
        // implement your logic
    }
}

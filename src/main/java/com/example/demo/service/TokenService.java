package com.example.demo.service;

import com.example.demo.entity.BreachAlert;

public interface TokenService {

    BreachAlert getToken(Long tokenId);

    BreachAlert updateStatus(Long tokenId, String status);
}

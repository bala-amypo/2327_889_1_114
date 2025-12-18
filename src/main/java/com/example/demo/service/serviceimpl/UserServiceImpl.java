package com.example.service;

import com.example.model.User;
import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> findByEmail(String email);
}
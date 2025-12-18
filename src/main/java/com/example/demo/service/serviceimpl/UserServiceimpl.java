package com.example.tokenmanagement.service.impl;

import org.springframework.stereotype.Service;

import com.example.tokenmanagement.exception.NotFoundException;
import com.example.tokenmanagement.model.User;
import com.example.tokenmanagement.repository.UserRepository;
import com.example.tokenmanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}

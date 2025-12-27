package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    // Register a new user
    User register(User user);

    // Login method (returns user by email)
    User login(String email, String password);

    // Optional: findByEmail method (needed for test file)
    User findByEmail(String email);
}

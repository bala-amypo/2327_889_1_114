package com.example.model.service;

import com.example.demo.model.User;

public interface UserService {

    User register(User user);

    User findByEmail(String email);
}

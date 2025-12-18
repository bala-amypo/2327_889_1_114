package com.example.tokenmanagement.service;

import com.example.demo.tokenmanagement.model.User;

public interface UserService {

    User register(User user);

    User findByEmail(String email);
}

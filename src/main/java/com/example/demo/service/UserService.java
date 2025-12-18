package com.example.tokenmanagement.service;

import com.example.tokenmanagement.model.User;

public interface UserService {

    User register(User user);

    User findByEmail(String email);
}

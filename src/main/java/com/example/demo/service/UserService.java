// package com.example.demo.service;

// import com.example.demo.entity.User;

// public interface UserService {
//     User register(User user);
//     User findByEmail(String email);
// }
package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Register a new user
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        return repo.save(user);
    }

    // Find user by username
    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    // Find user by email
    public User findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}

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

    public User register(User user) {
        // Encrypt password
        user.setPassword(encoder.encode(user.getPassword()));
        // Set default role
        user.setRole("USER");  // now works because 'role' exists
        return repo.save(user);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }
}

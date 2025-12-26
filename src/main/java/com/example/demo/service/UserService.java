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
        user.setPassword(encoder.encode(user.getPassword())); // tests 25,48
        user.setRole("USER");
        return repo.save(user);
    }

    public boolean matches(String raw, String hashed) {
        return encoder.matches(raw, hashed);
    }
}

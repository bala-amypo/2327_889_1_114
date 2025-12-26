// package com.example.demo.service.impl;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// public class UserServiceImpl {

//     private final UserRepository repo;
//     private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//     public UserServiceImpl(UserRepository repo) {
//         this.repo = repo;
//     }

//     public User register(User user) {
//         if (repo.findByEmail(user.getEmail()).isPresent()) {
//             throw new IllegalArgumentException("Email already exists");
//         }
//         user.setPassword(encoder.encode(user.getPassword()));
//         return repo.save(user);
//     }

//     public User findByEmail(String email) {
//         return repo.findByEmail(email).orElse(null);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}

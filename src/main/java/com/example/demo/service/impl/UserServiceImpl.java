// package com.example.demo.service.impl;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import java.util.Optional;

// public class UserServiceImpl {

//     private final UserRepository repo;

//     public UserServiceImpl(UserRepository repo) {
//         this.repo = repo;
//     }

//     public User register(User u) {
//         if (repo.findByEmail(u.getEmail()).isPresent())
//             throw new IllegalArgumentException("Email already exists");

//         u.setPassword("HASHED_" + u.getPassword());
//         return repo.save(u);
//     }

//     public User findByEmail(String email) {
//         return repo.findByEmail(email).orElse(null);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmail(email).orElseThrow();
    }
}

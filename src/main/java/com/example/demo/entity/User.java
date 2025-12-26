// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     @Column(nullable = false)
//     private String role;   // 👈 ADD THIS

//     public User() {}

//     public User(String email, String password, String role) {
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }

//     public Long getId() {
//         return id;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public String getRole() {     // 👈 THIS FIXES YOUR ERROR
//         return role;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }
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

    // Register new user
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");  // default role
        return repo.save(user);
    }

    // Find user by username
    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);  // uses new repository method
    }
}

package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class FullProjectTest {

    public static void main(String[] args) {

        // Dummy repository (ONLY required method)
        UserRepository userRepository = new UserRepository() {
            @Override
            public Optional<User> findByEmail(String email) {
                User user = new User();
                user.setEmail(email);
                user.setPassword("1234");
                return Optional.of(user);
            }
        };

        // PasswordEncoder FIX (no lambda)
        PasswordEncoder passwordEncoder = new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };

        UserServiceImpl userService =
                new UserServiceImpl(userRepository, passwordEncoder);

        User user = userService.findByEmail("test@gmail.com");

        if (user != null) {
            System.out.println("SUCCESS: " + user.getEmail());
        } else {
            System.out.println("FAILED");
        }
    }
}

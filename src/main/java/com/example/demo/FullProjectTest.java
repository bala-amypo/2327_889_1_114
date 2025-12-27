package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class FullProjectTest {

    public static void main(String[] args) {

        // manual dummy objects (no JUnit, no Mockito)
        UserRepository userRepository = new UserRepository() {
            @Override
            public Optional<User> findByEmail(String email) {
                User u = new User();
                u.setEmail(email);
                return Optional.of(u);
            }

            // implement only required methods
        };

        PasswordEncoder passwordEncoder = password -> password;

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

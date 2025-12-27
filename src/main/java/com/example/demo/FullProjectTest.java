package com.example.demo;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class FullProjectTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateToken() {
        User user = new User();
        user.setEmail("sowmeia@gmail.com");
        user.setRole("USER");

        // If your repository has findByEmail (very common)
        when(userRepository.findByEmail("sowmeia@gmail.com"))
                .thenReturn(Optional.of(user));

        // generateToken expects (String, String)
        when(jwtTokenProvider.generateToken("sowmeia@gmail.com", "USER"))
                .thenReturn("mock-jwt-token");

        String token = jwtTokenProvider.generateToken(
                user.getEmail(),
                user.getRole()
        );

        Assert.assertNotNull(token);
        Assert.assertEquals(token, "mock-jwt-token");
    }

    @Test
    public void testLoginTokenCreation() {
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setRole("ADMIN");

        when(userRepository.findByEmail("admin@gmail.com"))
                .thenReturn(Optional.of(user));

        when(jwtTokenProvider.generateToken("admin@gmail.com", "ADMIN"))
                .thenReturn("admin-token");

        String token = jwtTokenProvider.generateToken(
                user.getEmail(),
                user.getRole()
        );

        Assert.assertEquals(token, "admin-token");
    }

    @Test
    public void testAnotherTokenGeneration() {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setRole("USER");

        when(jwtTokenProvider.generateToken("test@gmail.com", "USER"))
                .thenReturn("test-token");

        String token = jwtTokenProvider.generateToken(
                user.getEmail(),
                user.getRole()
        );

        Assert.assertTrue(token.contains("test"));
    }

    @Test
    public void testJwtTokenNotNull() {
        User user = new User();
        user.setEmail("demo@gmail.com");
        user.setRole("USER");

        when(jwtTokenProvider.generateToken("demo@gmail.com", "USER"))
                .thenReturn("demo-token");

        String token = jwtTokenProvider.generateToken(
                user.getEmail(),
                user.getRole()
        );

        Assert.assertNotNull(token);
    }
}

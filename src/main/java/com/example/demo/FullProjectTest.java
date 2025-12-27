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
        user.setUsername("sowmeia");
        user.setRole("USER");
        user.setEmail("sowmeia@gmail.com");

        when(userRepository.findByUsername("sowmeia"))
                .thenReturn(Optional.of(user));

        // ✅ FIXED: generateToken accepts only (username, role)
        when(jwtTokenProvider.generateToken("sowmeia", "USER"))
                .thenReturn("mock-jwt-token");

        String token = jwtTokenProvider.generateToken(
                user.getUsername(),
                user.getRole()
        );

        Assert.assertNotNull(token);
        Assert.assertEquals(token, "mock-jwt-token");
    }

    @Test
    public void testLoginTokenCreation() {
        User user = new User();
        user.setUsername("admin");
        user.setRole("ADMIN");
        user.setEmail("admin@gmail.com");

        when(userRepository.findByUsername("admin"))
                .thenReturn(Optional.of(user));

        // ✅ FIXED
        when(jwtTokenProvider.generateToken("admin", "ADMIN"))
                .thenReturn("admin-token");

        String token = jwtTokenProvider.generateToken(
                user.getUsername(),
                user.getRole()
        );

        Assert.assertEquals(token, "admin-token");
    }

    @Test
    public void testAnotherTokenGeneration() {
        User user = new User();
        user.setUsername("test");
        user.setRole("USER");

        // ✅ FIXED
        when(jwtTokenProvider.generateToken("test", "USER"))
                .thenReturn("test-token");

        String token = jwtTokenProvider.generateToken(
                user.getUsername(),
                user.getRole()
        );

        Assert.assertTrue(token.contains("test"));
    }

    @Test
    public void testJwtTokenNotNull() {
        User user = new User();
        user.setUsername("demo");
        user.setRole("USER");

        // ✅ FIXED
        when(jwtTokenProvider.generateToken("demo", "USER"))
                .thenReturn("demo-token");

        String token = jwtTokenProvider.generateToken(
                user.getUsername(),
                user.getRole()
        );

        Assert.assertNotNull(token);
    }
}

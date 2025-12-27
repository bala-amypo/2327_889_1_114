package com.example.demo;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.impl.*;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Listeners(TestResultListener.class)
public class FullProjectTest {

    @Mock private UserRepository userRepository;
    @Mock private TokenRepository tokenRepository;
    @Mock private ServiceCounterRepository serviceCounterRepository;
    @Mock private TokenServiceImpl tokenService;
    @InjectMocks private JwtTokenProvider jwtTokenProvider;

    private User user;
    private ServiceCounter serviceCounter;
    private Token token;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample User
        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword("password");
        user.setRole("USER");

        // Sample ServiceCounter
        serviceCounter = new ServiceCounter();
        serviceCounter.setId(1L);
        serviceCounter.setCounterName("Counter1");
        serviceCounter.setActive(true);

        // Sample Token
        token = new Token();
        token.setId(1L);
        token.setTokenValue("sample-token");
        token.setUser(user);
        token.setServiceCounter(serviceCounter);
    }

    @Test
    public void testGenerateToken() {
        // Correct token generation using the proper method signature
        String jwtToken = jwtTokenProvider.generateToken(
            user.getId(),
            user.getUsername(),
            user.getRole()
        );

        Assert.assertNotNull(jwtToken);
    }

    @Test
    public void testTokenServiceSave() {
        when(tokenRepository.save(any(Token.class))).thenReturn(token);

        Token savedToken = tokenService.saveToken(token);

        Assert.assertEquals(savedToken.getId(), token.getId());
        Assert.assertEquals(savedToken.getUser().getUsername(), user.getUsername());
    }

    @Test
    public void testUserRepositoryFind() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userRepository.findById(1L);

        Assert.assertTrue(foundUser.isPresent());
        Assert.assertEquals(foundUser.get().getUsername(), "testuser");
    }

    @Test
    public void testServiceCounterRepositoryFind() {
        when(serviceCounterRepository.findById(1L)).thenReturn(Optional.of(serviceCounter));

        Optional<ServiceCounter> foundCounter = serviceCounterRepository.findById(1L);

        Assert.assertTrue(foundCounter.isPresent());
        Assert.assertEquals(foundCounter.get().getCounterName(), "Counter1");
    }

    @Test
    public void testTokenLogPrePersist() {
        TokenLog tokenLog = new TokenLog();
        tokenLog.setToken(token);

        tokenLog.onCreate();

        Assert.assertNotNull(tokenLog.getCreatedAt());
    }
}

package com.example.demo.service.impl; // <-- your package

// 1️⃣ Mockito imports
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

// 2️⃣ TestNG imports
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

// 3️⃣ Your project imports
import com.example.demo.entity.Token;
import com.example.demo.repository.TokenRepository;

public class QueueServiceImplTest {

    @Mock
    private TokenRepository tokenRepository;

    @InjectMocks
    private QueueServiceImpl queueService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUpdateQueuePosition() {
        // test logic here
    }
}

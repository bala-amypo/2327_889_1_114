package com.example.demo.service.impl;

import com.example.demo.entity.Token;
import com.example.demo.repository.TokenRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

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
        Token token = new Token();
        token.setQueuePosition(1);
        token.setId(1L);

        when(tokenRepository.findById(1L)).thenReturn(Optional.of(token));
        when(tokenRepository.save(any(Token.class))).thenReturn(token);

        queueService.updateQueuePosition(1L, 5);

        Assert.assertEquals(token.getQueuePosition().intValue(), 5);
        verify(tokenRepository, times(1)).save(token);
    }
}

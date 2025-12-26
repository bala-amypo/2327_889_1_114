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

public class TokenServiceImplTest {

    @Mock
    private TokenRepository tokenRepository;

    @InjectMocks
    private TokenServiceImpl tokenService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetToken() {
        Token token = new Token();
        token.setId(1L);
        token.setQueuePosition(3);

        when(tokenRepository.findById(1L)).thenReturn(Optional.of(token));

        Token result = tokenService.getToken(1L);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getQueuePosition().intValue(), 3);
        verify(tokenRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdateQueuePosition() {
        Token token = new Token();
        token.setId(1L);
        token.setQueuePosition(2);

        when(tokenRepository.findById(1L)).thenReturn(Optional.of(token));
        when(tokenRepository.save(any(Token.class))).thenReturn(token);

        tokenService.updateQueuePosition(1L, 7);

        Assert.assertEquals(token.getQueuePosition().intValue(), 7);
        verify(tokenRepository, times(1)).save(token);
    }
}

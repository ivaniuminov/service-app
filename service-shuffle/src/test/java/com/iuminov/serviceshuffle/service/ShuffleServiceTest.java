package com.iuminov.serviceshuffle.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShuffleServiceTest {

    @Mock
    private LogService logService;

    @Mock
    private RandomArrayGenerator randomArrayGenerator;

    @InjectMocks
    private ShuffleService shuffleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateShuffle() {
        // Given
        Integer length = 5;
        Integer[] expectedArray = {1, 2, 3, 4, 5};
        when(randomArrayGenerator.generateRandom(length)).thenReturn(expectedArray);

        // When
        Integer[] result = shuffleService.createShuffle(length);

        // Then
        assertArrayEquals(expectedArray, result, "The arrays should be the same");
        verify(logService, times(1)).logArray(expectedArray);
    }
}
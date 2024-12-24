package com.iuminov.serviceshuffle.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

import static org.mockito.Mockito.verify;

@SpringBootTest
@EnableAsync
public class LogServiceTest {

    private ServiceLogClient serviceLogClient;
    private LogService logService;

    @BeforeEach
    public void setUp() {
        serviceLogClient = Mockito.mock(ServiceLogClient.class);
        logService = new LogService(serviceLogClient);
    }

    @Test
    public void logArray_shouldCallServiceLogClient() throws InterruptedException {
        // Given
        Integer[] array = {1, 2, 3, 4, 5};

        // When
        logService.logArray(array);
        Thread.sleep(100);

        // Then
        verify(serviceLogClient).logArray(array);
    }
}
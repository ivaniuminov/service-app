package com.iuminov.servicelog.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.slf4j.Logger;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LogServiceTest {

    @Test
    void logArray_shouldLogArrayContent() {
        // Given
        Logger mockLogger = mock(Logger.class);
        LogService logService = new LogService() {
            private final Logger LOGGER = mockLogger;

            @Override
            public void logArray(Integer[] array) {
                LOGGER.info(" ---- Array received: " + Arrays.toString(array));
            }
        };

        Integer[] testArray = {1, 2, 3, 4};

        // WHen
        logService.logArray(testArray);

        // Then
        ArgumentCaptor<String> logCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockLogger).info(logCaptor.capture());

        String loggedMessage = logCaptor.getValue();
        assertTrue(loggedMessage.contains(" ---- Array received: [1, 2, 3, 4]"),
                "Logged message should contain the expected array content");
    }
}
package com.iuminov.servicelog.controller;

import com.iuminov.servicelog.service.LogService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LogController.class)
class LogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LogService logService;

    @Configuration
    static class TestConfig {
        @Bean
        public LogService logService() {
            return Mockito.mock(LogService.class);
        }

        @Bean
        public LogController logController(LogService logService) {
            return new LogController(logService);
        }
    }

    @Test
    void logArray_shouldReturnNoContent() throws Exception {
        // Given
        String requestBody = "[1, 2, 3, 4]";

        // When
        mockMvc.perform(post("/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isNoContent());

        // Then
        verify(logService).logArray(new Integer[]{1, 2, 3, 4});
    }
}
package com.iuminov.serviceshuffle.controller;

import com.iuminov.serviceshuffle.service.ShuffleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShuffleController.class)
class ShuffleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShuffleService shuffleService;

    @InjectMocks
    private ShuffleController shuffleController;

    @Test
    void createShuffle_shouldReturnShuffledArray() throws Exception {
        // Given
        Integer length = 5;
        Integer[] shuffledArray = {4, 2, 3, 1, 5};
        when(shuffleService.createShuffle(length)).thenReturn(shuffledArray);

        // When
        mockMvc.perform(post("/shuffle")
                        .param("length", String.valueOf(length)))
                .andExpect(status().isOk());

        // Then
        verify(shuffleService).createShuffle(length);
    }

    @Test
    void createShuffle_shouldReturnBadRequestWhenLengthIsTooShort() throws Exception {
        // Given
        Integer length = 0;

        // When & Then
        mockMvc.perform(post("/shuffle")
                        .param("length", String.valueOf(length)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createShuffle_shouldReturnBadRequestWhenLengthIsTooLong() throws Exception {
        // Given
        Integer length = 1001;

        // When & Then
        mockMvc.perform(post("/shuffle")
                        .param("length", String.valueOf(length)))
                .andExpect(status().isBadRequest());
    }
}
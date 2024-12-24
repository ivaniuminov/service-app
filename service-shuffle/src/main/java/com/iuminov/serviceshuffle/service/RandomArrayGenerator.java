package com.iuminov.serviceshuffle.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class RandomArrayGenerator {

    public Integer[] generateRandom(Integer length) {
        Integer[] numbers = new Integer[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = i;
        }

        Collections.shuffle(Arrays.asList(numbers));
        return numbers;
    }
}

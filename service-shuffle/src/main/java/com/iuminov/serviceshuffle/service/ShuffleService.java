package com.iuminov.serviceshuffle.service;

import org.springframework.stereotype.Service;

@Service
public class ShuffleService {

    private final LogService logService;
    private final RandomArrayGenerator generateRandom;

    public ShuffleService(LogService logService, RandomArrayGenerator generateRandom) {
        this.logService = logService;
        this.generateRandom = generateRandom;
    }

    public Integer[] createShuffle(Integer length) {
        Integer[] array = generateRandom.generateRandom(length);
        logService.logArray(array);
        return array;
    }
}

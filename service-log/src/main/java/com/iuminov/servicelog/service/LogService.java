package com.iuminov.servicelog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);
    public void logArray(Integer[] array) {
        LOGGER.info(" ---- Array received: " + Arrays.toString(array));
    }
}

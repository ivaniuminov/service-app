package com.iuminov.serviceshuffle.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final ServiceLogClient serviceLogClient;

    public LogService(ServiceLogClient serviceLogClient) {
        this.serviceLogClient = serviceLogClient;
    }

    @Async
    public void logArray(Integer[] array) {
        serviceLogClient.logArray(array);
    }
}

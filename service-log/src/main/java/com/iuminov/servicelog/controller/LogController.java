package com.iuminov.servicelog.controller;

import com.iuminov.servicelog.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/log")
    public ResponseEntity<Void> logArray(@RequestBody Integer[] array) {
        logService.logArray(array);
        return ResponseEntity.noContent().build();
    }
}

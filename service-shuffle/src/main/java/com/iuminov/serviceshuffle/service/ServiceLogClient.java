package com.iuminov.serviceshuffle.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface ServiceLogClient {

    @PostExchange
    ResponseEntity<Void> logArray(@RequestBody Integer[] array);
}

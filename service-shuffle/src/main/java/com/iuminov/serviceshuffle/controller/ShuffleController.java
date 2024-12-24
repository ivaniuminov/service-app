package com.iuminov.serviceshuffle.controller;

import com.iuminov.serviceshuffle.service.ShuffleService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class ShuffleController {

    private final ShuffleService shuffleService;

    public ShuffleController(ShuffleService shuffleService) {
        this.shuffleService = shuffleService;
    }

    @PostMapping("/shuffle")
    public ResponseEntity<Integer[]> createShuffle(@RequestParam("length") @Min(1) @Max(1000) Integer length) {

        return ResponseEntity.ok(shuffleService.createShuffle(length));
    }
}

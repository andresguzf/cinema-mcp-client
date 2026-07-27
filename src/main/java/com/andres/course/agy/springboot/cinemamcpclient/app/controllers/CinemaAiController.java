package com.andres.course.agy.springboot.cinemamcpclient.app.controllers;

import com.andres.course.agy.springboot.cinemamcpclient.app.services.CinemaAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinema")
public class CinemaAiController {

    private final CinemaAiService cinemaAiService;

    public CinemaAiController(CinemaAiService cinemaAiService) {
        this.cinemaAiService = cinemaAiService;
    }

    @GetMapping("/ask")
    public ResponseEntity<String> ask(@RequestParam("q") String q) {
        String answer = this.cinemaAiService.ask(q);
        return ResponseEntity.ok(answer);
    }

}

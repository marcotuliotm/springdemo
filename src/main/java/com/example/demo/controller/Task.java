package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "tasks", produces = MediaType.APPLICATION_JSON_VALUE )
public class Task {

    @GetMapping
    public ResponseEntity<String> findAll() {

        return ResponseEntity.ok("OLA" );
    }
}

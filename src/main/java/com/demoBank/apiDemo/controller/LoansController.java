package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.LoansService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/loans")
public class LoansController {

    private final LoansService loansService;

    public LoansController(LoansService loansService) {
        this.loansService = loansService;
    }

    @GetMapping
    public ResponseEntity<JsonNode> getLoans(
            @RequestParam String asOfDate,
            @RequestParam(required = false, defaultValue = "false") Boolean includeClosed,
            @RequestParam(required = false, defaultValue = "100") Integer size,
            @RequestParam(required = false) String cursor) {
        try {
            JsonNode data = loansService.getLoansData();
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


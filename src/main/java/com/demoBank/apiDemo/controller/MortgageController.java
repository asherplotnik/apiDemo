package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.MortgageService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/mortgages")
public class MortgageController {

    private final MortgageService mortgageService;

    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @GetMapping
    public ResponseEntity<JsonNode> getMortgages(
            @RequestParam String asOfDate,
            @RequestParam(required = false, defaultValue = "false") Boolean includeClosed,
            @RequestParam(required = false, defaultValue = "100") Integer size,
            @RequestParam(required = false) String cursor) {
        try {
            JsonNode data = mortgageService.getMortgageData();
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


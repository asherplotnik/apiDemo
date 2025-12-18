package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.DepositsService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/deposits")
public class DepositsController {

    private final DepositsService depositsService;

    public DepositsController(DepositsService depositsService) {
        this.depositsService = depositsService;
    }

    @GetMapping
    public ResponseEntity<JsonNode> getDeposits(
            @RequestParam String asOfDate,
            @RequestParam(required = false, defaultValue = "false") Boolean includeClosed,
            @RequestParam(required = false, defaultValue = "100") Integer size,
            @RequestParam(required = false) String cursor) {
        try {
            JsonNode data = depositsService.getDepositsData();
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


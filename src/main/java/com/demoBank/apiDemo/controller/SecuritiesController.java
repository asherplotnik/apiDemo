package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.SecuritiesService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/securities")
public class SecuritiesController {

    private final SecuritiesService securitiesService;

    public SecuritiesController(SecuritiesService securitiesService) {
        this.securitiesService = securitiesService;
    }

    @GetMapping
    public ResponseEntity<JsonNode> getSecurities(
            @RequestParam String asOfDate,
            @RequestParam(required = false, defaultValue = "false") Boolean includeClosed,
            @RequestParam(required = false, defaultValue = "100") Integer size,
            @RequestParam(required = false) String cursor) {
        try {
            JsonNode data = securitiesService.getSecuritiesData();
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


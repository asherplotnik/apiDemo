package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.CreditCardsService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/credit-cards")
public class CreditCardsController {

    private final CreditCardsService creditCardsService;

    public CreditCardsController(CreditCardsService creditCardsService) {
        this.creditCardsService = creditCardsService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<JsonNode> getCreditCardsTransactions(
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false, defaultValue = "true") Boolean includePending,
            @RequestParam(required = false, defaultValue = "25") Integer size,
            @RequestParam(required = false) String cursor,
            @RequestParam(required = false, defaultValue = "Asia/Jerusalem") String timezone) {
        try {
            JsonNode data = creditCardsService.getCreditCardsData();
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


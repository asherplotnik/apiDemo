package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.CurrentAccountsService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/current-accounts")
public class CurrentAccountsController {

    private final CurrentAccountsService currentAccountsService;

    public CurrentAccountsController(CurrentAccountsService currentAccountsService) {
        this.currentAccountsService = currentAccountsService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<JsonNode> getCurrentAccountsTransactions(
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false, defaultValue = "true") Boolean includePending,
            @RequestParam(required = false, defaultValue = "100") Integer pageSize,
            @RequestParam(required = false) String cursor,
            @RequestParam(required = false, defaultValue = "Asia/Jerusalem") String timezone) {
        try {
            JsonNode data = currentAccountsService.getCurrentAccountsData();
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


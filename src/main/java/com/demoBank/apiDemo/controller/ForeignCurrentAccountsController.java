package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.ForeignCurrentAccountsService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/foreign-current-accounts")
public class ForeignCurrentAccountsController {

    private final ForeignCurrentAccountsService foreignCurrentAccountsService;

    public ForeignCurrentAccountsController(ForeignCurrentAccountsService foreignCurrentAccountsService) {
        this.foreignCurrentAccountsService = foreignCurrentAccountsService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<JsonNode> getForeignCurrentAccountsTransactions(
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false, defaultValue = "true") Boolean includePending,
            @RequestParam(required = false, defaultValue = "100") Integer pageSize,
            @RequestParam(required = false) String cursor,
            @RequestParam(required = false, defaultValue = "Asia/Jerusalem") String timezone) {
        try {
            JsonNode data = foreignCurrentAccountsService.getForeignCurrentAccountsData();
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


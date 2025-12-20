package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.CurrentAccountsService;
import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/current-accounts")
public class CurrentAccountsController {

    private final CurrentAccountsService currentAccountsService;

    public CurrentAccountsController(CurrentAccountsService currentAccountsService) {
        this.currentAccountsService = currentAccountsService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<Document> getCurrentAccountsTransactions(
            @RequestHeader String customerID,
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false, defaultValue = "true") Boolean includePending,
            @RequestParam(required = false, defaultValue = "100") Integer pageSize,
            @RequestParam(required = false) String cursor,
            @RequestParam(required = false, defaultValue = "Asia/Jerusalem") String timezone,
            @RequestParam(required = false) List<String> accountList,
            @RequestParam(required = false, defaultValue = "true") Boolean includeTransactions) {
        try {
            Document data = currentAccountsService.getCurrentAccountsData(customerID, fromDate, toDate, accountList, includeTransactions);
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


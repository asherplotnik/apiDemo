package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.LoansService;
import org.bson.Document;
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
    public ResponseEntity<Document> getLoans(
            @RequestHeader String customerID,
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false, defaultValue = "false") Boolean includeClosed,
            @RequestParam(required = false, defaultValue = "100") Integer size,
            @RequestParam(required = false) String cursor,
            @RequestParam(required = false) String nicknameFilter,
            @RequestParam(required = false, defaultValue = "true") Boolean includeTransactions) {
        try {
            Document data = loansService.getLoansData(customerID, fromDate, toDate, nicknameFilter, includeTransactions);
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


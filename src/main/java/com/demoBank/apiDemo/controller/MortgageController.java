package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.MortgageService;
import org.bson.Document;
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
    public ResponseEntity<Document> getMortgages(
            @RequestHeader String customerID,
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false, defaultValue = "false") Boolean includeClosed,
            @RequestParam(required = false, defaultValue = "100") Integer size,
            @RequestParam(required = false) String cursor,
            @RequestParam(required = false) String nicknameFilter,
            @RequestParam(required = false, defaultValue = "true") Boolean includeTransactions) {
        try {
            Document data = mortgageService.getMortgageData(customerID, fromDate, toDate, nicknameFilter, includeTransactions);
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


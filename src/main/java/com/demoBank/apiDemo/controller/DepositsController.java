package com.demoBank.apiDemo.controller;

import com.demoBank.apiDemo.service.DepositsService;
import org.bson.Document;
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
    public ResponseEntity<Document> getDeposits(
            @RequestHeader String customerID,
            @RequestParam String fromDate,
            @RequestParam String toDate,
            @RequestParam(required = false, defaultValue = "false") Boolean includeClosed,
            @RequestParam(required = false, defaultValue = "100") Integer size,
            @RequestParam(required = false) String cursor,
            @RequestParam(required = false) String nicknameFilter,
            @RequestParam(required = false, defaultValue = "true") Boolean includeTransactions) {
        try {
            Document data = depositsService.getDepositsData(customerID, fromDate, toDate, nicknameFilter, includeTransactions);
            return ResponseEntity.ok(data);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}


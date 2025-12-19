package com.demoBank.apiDemo.service;

import com.demoBank.apiDemo.repository.GenericMongoRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LoansService {
    private final GenericMongoRepository repository;

    public LoansService(GenericMongoRepository repository) {
        this.repository = repository;
    }

    public Document getLoansData(String customerID) throws IOException {
        return repository.findById("loans", customerID);
    }
}

package com.demoBank.apiDemo.service;

import com.demoBank.apiDemo.repository.GenericMongoRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MortgageService {
    private final GenericMongoRepository repository;

    public MortgageService(GenericMongoRepository repository) {
        this.repository = repository;
    }

    public Document getMortgageData(String customerID) throws IOException {
        return repository.findById("mortgages", customerID);
    }
}

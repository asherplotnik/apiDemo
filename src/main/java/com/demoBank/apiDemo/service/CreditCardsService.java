package com.demoBank.apiDemo.service;

import com.demoBank.apiDemo.repository.GenericMongoRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreditCardsService {
    private final GenericMongoRepository repository;

    public CreditCardsService(GenericMongoRepository repository) {
        this.repository = repository;
    }

    public Document getCreditCardsData(String customerID) throws IOException {
        return repository.findById("creditCards", customerID);
    }
}


package com.demoBank.apiDemo.service;

import com.demoBank.apiDemo.repository.GenericMongoRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ForeignCurrentAccountsService {
    private final GenericMongoRepository repository;

    public ForeignCurrentAccountsService(GenericMongoRepository repository) {
        this.repository = repository;
    }

    public Document getForeignCurrentAccountsData(String customerID) throws IOException {
        return repository.findById("foreignCurrentAccountTransactions", customerID);
    }
}

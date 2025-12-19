package com.demoBank.apiDemo.service;

import com.demoBank.apiDemo.repository.GenericMongoRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class CurrentAccountsService {
    private final GenericMongoRepository repository;

    public CurrentAccountsService(GenericMongoRepository repository) {
        this.repository = repository;
    }

    public Document getCurrentAccountsData(String customerID) throws IOException {
        return repository.findById("currentAccountTransactions", customerID);
    }
}

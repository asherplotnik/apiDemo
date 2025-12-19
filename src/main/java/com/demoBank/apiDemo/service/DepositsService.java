package com.demoBank.apiDemo.service;

import com.demoBank.apiDemo.repository.GenericMongoRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DepositsService {
    private final GenericMongoRepository repository;

    public DepositsService(GenericMongoRepository repository) {
        this.repository = repository;
    }

    public Document getDepositsData(String customerID) throws IOException {
        return repository.findById("deposits", customerID);
    }
}

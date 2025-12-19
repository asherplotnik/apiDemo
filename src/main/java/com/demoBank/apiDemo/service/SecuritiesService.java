package com.demoBank.apiDemo.service;

import com.demoBank.apiDemo.repository.GenericMongoRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SecuritiesService {
    private final GenericMongoRepository repository;

    public SecuritiesService(GenericMongoRepository repository) {
        this.repository = repository;
    }

    public Document getSecuritiesData(String customerID) throws IOException {
        return repository.findById("securities", customerID);
    }
}

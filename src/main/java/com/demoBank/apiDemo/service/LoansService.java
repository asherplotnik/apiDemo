package com.demoBank.apiDemo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class LoansService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getLoansData() throws IOException {
        String jsonPath = "APIs/loans/loansOutput.json";
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonPath)));
        return objectMapper.readTree(jsonContent);
    }
}


package com.demoBank.apiDemo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class CreditCardsService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getCreditCardsData() throws IOException {
        // Read JSON file from APIs folder (relative to project root)
        String jsonPath = "APIs/creditCards/creditCardsOutput.json";
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonPath)));
        return objectMapper.readTree(jsonContent);
    }
}


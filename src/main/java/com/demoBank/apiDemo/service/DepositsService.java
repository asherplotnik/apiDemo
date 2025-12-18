package com.demoBank.apiDemo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class DepositsService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getDepositsData() throws IOException {
        String jsonPath = "APIs/deposits/depositsOutput.json";
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonPath)));
        return objectMapper.readTree(jsonContent);
    }
}


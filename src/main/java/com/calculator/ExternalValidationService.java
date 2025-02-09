package com.calculator;

public class ExternalValidationService {
    private static final String VALIDATION_ENDPOINT = System.getenv().getOrDefault(
        "VALIDATION_ENDPOINT", 
        "https://api.calculator-validation.example.com/validate"
    );

    public boolean isValidKey(String apiKey) {
        // In a real application, this would make an HTTP request
        // to validate the API key against a remote service
        
        // For demo purposes, just check if the key exists
        // and has the correct format (e.g., UUID format)
        return apiKey != null && 
               !apiKey.isEmpty() && 
               apiKey.matches("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4[a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}");
    }
}
package com.calculator;

public class Calculator {
    private final String apiKey;
    private final ExternalValidationService validationService;
    
    public Calculator() {
        this.apiKey = System.getenv().getOrDefault("CALCULATOR_API_KEY", "");
        this.validationService = new ExternalValidationService();
    }

    // Basic operations (no validation needed)
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }

    // Premium operations (require validation)
    public double multiply(double a, double b) {
        if (!validationService.isValidKey(apiKey)) {
            throw new IllegalStateException("Invalid or missing API key for premium features");
        }
        return a * b;
    }

    public double divide(double a, double b) {
        if (!validationService.isValidKey(apiKey)) {
            throw new IllegalStateException("Invalid or missing API key for premium features");
        }
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testBasicOperations() {
        assertEquals(4, calculator.add(2, 2), "Basic addition should work without API key");
        assertEquals(2, calculator.subtract(4, 2), "Basic subtraction should work without API key");
    }

    @Test
    void testPremiumOperationsWithoutKey() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            calculator.multiply(2, 3);
        });
        assertTrue(exception.getMessage().contains("Invalid or missing API key"));
        
        exception = assertThrows(IllegalStateException.class, () -> {
            calculator.divide(4, 2);
        });
        assertTrue(exception.getMessage().contains("Invalid or missing API key"));
    }

    @Test
    void testDivideByZero() {
        // Even with invalid API key, should check for divide by zero first
        assertThrows(IllegalStateException.class, () -> calculator.divide(1, 0));
    }
}
package com.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(4, calculator.add(2, 2), "2 + 2 should equal 4");
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(4, 2), "4 - 2 should equal 2");
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(4, 2), "4 / 2 should equal 2.0");
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, 
            () -> calculator.divide(1, 0), 
            "Dividing by zero should throw IllegalArgumentException");
    }
}
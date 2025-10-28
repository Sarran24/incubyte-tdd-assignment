package com.example.tdd;

import com.example.tdd.service.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void shouldReturnZeroForEmptyString() {
        int result = calculator.add("");
        assertThat(result).isZero();
    }

    @Test
    void singleNumberReturnsValue() {
        var calc = new com.example.tdd.service.StringCalculator();
        assertThat(calc.add("5")).isEqualTo(5);

    }

}

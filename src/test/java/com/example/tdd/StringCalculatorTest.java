package com.example.tdd;

import com.example.tdd.service.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    private StringCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new StringCalculator();
    }

    @Test
    void emptyStringReturnsZero() {
        assertThat(calc.add("")).isEqualTo(0);
    }

    @Test
    void singleNumberReturnsValue() {
        assertThat(calc.add("5")).isEqualTo(5);
    }

    @Test
    void twoNumbersCommaSeparated() {
        assertThat(calc.add("1,2")).isEqualTo(3);
    }

}


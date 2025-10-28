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

    @Test
    void newlineAsDelimiter() {
        assertThat(calc.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void customDelimiter() {
        assertThat(calc.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void negativeNumbersThrow() {
        var thrown = org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calc.add("1,-2,3,-4")
        );
        assertThat(thrown.getMessage()).contains("-2", "-4");
    }

    @Test
    void numbersGreaterThan1000Ignored() {
        assertThat(calc.add("2,1001,6")).isEqualTo(8); // 1001 ignored
    }


}


package com.example.tdd;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void emptyStringReturnsZero() {

        var calc = new com.example.tdd.service.StringCalculator();

        int result = calc.add("");

        assertThat(result).isEqualTo(0);
    }
}

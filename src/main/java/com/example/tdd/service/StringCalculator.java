package com.example.tdd.service;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) return 0;
        return sumOf(numbersFrom(input));
    }

    private int sumOf(String[] parts) {
        return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
    }

    private String[] numbersFrom(String input) {
        String delimiterRegex = ",|\n"; // default delimiters
        String numbers = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex > 2) { // ensure there's a delimiter spec
                String delimiterSpec = input.substring(2, newlineIndex).trim();
                if (!delimiterSpec.isEmpty()) {
                    delimiterRegex = java.util.regex.Pattern.quote(delimiterSpec);
                }
            }
            numbers = input.substring(newlineIndex + 1);
        }

        return numbers.split(delimiterRegex);
    }


}

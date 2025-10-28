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
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            String delimSpec = input.substring(2, newlineIndex);
            String numbers = input.substring(newlineIndex + 1);
            String delimRegex = java.util.regex.Pattern.quote(delimSpec);
            return numbers.split(delimRegex);
        }
        return input.split(",|\n");
    }


}

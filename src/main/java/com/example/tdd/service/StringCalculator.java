package com.example.tdd.service;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) return 0;
        return sumOf(numbersFrom(input));
    }

    private int sumOf(String[] parts) {
        java.util.List<Integer> negatives = new java.util.ArrayList<>();
        int sum = 0;
        for (String p : parts) {
            if (p.isEmpty()) continue;
            int v = Integer.parseInt(p);
            if (v < 0) negatives.add(v);
            sum += v;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
        return sum;
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

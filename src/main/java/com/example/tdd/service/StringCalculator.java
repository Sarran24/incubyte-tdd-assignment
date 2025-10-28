package com.example.tdd.service;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) return 0;
        if (input.contains(",") || input.contains("\n")) {
            String[] parts = input.split("[,\n" +
                    "]");
            return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
        }
        return Integer.parseInt(input);
    }
}

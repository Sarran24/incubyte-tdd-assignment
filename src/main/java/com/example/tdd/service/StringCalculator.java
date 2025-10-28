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
        return input.split("[,\n" +
                "]");
    }

}

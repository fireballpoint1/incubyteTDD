package org.example;

import java.util.Arrays;

public class StringCalculator {
    public static int add(String numbers) {
        String defaultDelimiter = "[\n,]";
        int[] numbersArray = getNumbersArray(numbers, defaultDelimiter);
        int sum=0;
        int[] negativeNumbers = Arrays.stream(numbersArray).filter(n -> n < 0).toArray();
        if(negativeNumbers.length > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + Arrays.toString(negativeNumbers).replace("[", "").replace("]", "").replace(" ", ""));
        }
        for (int number : numbersArray) {
                sum += number;
        }
        return sum;
    }

    protected static int[] getNumbersArray(String numbers, String defaultDelimiter) {
        String[] numbersArray;
        if(numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiter = parts[0].substring(2);
            numbersArray = parts[1].split(delimiter);
        } else {
            numbersArray = numbers.split((defaultDelimiter));
        }
        return Arrays.stream(numbersArray).mapToInt(str -> str.isEmpty() ? 0 : Integer.parseInt(str)).toArray();
    }

}

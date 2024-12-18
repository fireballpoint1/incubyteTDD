package org.example;

public class StringCalculator {
    public static int add(String numbers) {
        String defaultDelimiter = "[\n,]";
        String[] numbersArray = getNumbersArray(numbers, defaultDelimiter);
        int sum=0;
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number);
                if(num < 0) {
                    throw new IllegalArgumentException("Negatives not allowed: " + num);
                }
                sum += num;
            }
        }
        return sum;
    }

    protected static String[] getNumbersArray(String numbers, String defaultDelimiter) {
        String[] numbersArray;
        if(numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiter = parts[0].substring(2);
            numbersArray = parts[1].split(delimiter);
        } else {
            numbersArray = numbers.split((defaultDelimiter));
        }
        return numbersArray;
    }

}

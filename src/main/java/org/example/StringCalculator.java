package org.example;

public class StringCalculator {
    public static int add(String numbers) {
        String[] numbersArray = new String[0];
        if(numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiter = parts[0].substring(2);
            numbersArray = parts[1].split(delimiter);
        } else {
            numbersArray = numbers.split(("[\n,]"));
        }
        int sum=0;
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }

}

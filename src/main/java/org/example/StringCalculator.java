package org.example;

import java.util.Arrays;

public class StringCalculator {
    private static String asteriskDelimiter = "\\*";
    public static int add(String numbers) {
        String defaultDelimiter = "[\n,]";
        String delimiter = getDelimiter(numbers,defaultDelimiter);
        int[] numbersArray = getNumbersArray(numbers, delimiter);
        int resultant=0;
        int[] negativeNumbers = Arrays.stream(numbersArray).filter(n -> n < 0).toArray();
        if(negativeNumbers.length > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + Arrays.toString(negativeNumbers).replace("[", "").replace("]", "").replace(" ", ""));
        }
        if(delimiter.equals(asteriskDelimiter)){
            resultant=1;
            for(int number: numbersArray){
                resultant= resultant*number;
            }
            return resultant;
        }
        for (int number : numbersArray) {
                resultant += number;
        }
        return resultant;
    }

    protected static int[] getNumbersArray(String numbers, String delimiter) {
        String[] numbersArray;
        if(numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            numbersArray = parts[1].split(delimiter);
        }
        else {
            numbersArray=numbers.split(delimiter);
        }
        return Arrays.stream(numbersArray).mapToInt(str -> str.isEmpty() ? 0 : Integer.parseInt(str)).toArray();
    }

    protected static String getDelimiter(String numbers, String defaultDelimiter){
        String[] numbersArray;
        String delimiter =defaultDelimiter;
        if(numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            delimiter = parts[0].substring(2);
            if(delimiter.equals("*")){
                delimiter=asteriskDelimiter;
            }
        }
        return delimiter;
    }


}

package org.example;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        else{
            String[] numbersArray = numbers.split(",");
            if(numbersArray.length > 1){
                return Integer.parseInt(numbersArray[0]) + Integer.parseInt(numbersArray[1]);
            } else {
                return Integer.parseInt(numbersArray[0]);
            }
        }
    }
}

import org.junit.jupiter.api.Test;

import static org.example.StringCalculator.add;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void givenEmptyStringReturnZero() {
        assertEquals(add(""),0);
    }

    @Test
    public void givenSingleNumberReturnNumber() {
        assertEquals(add("1"),1);
    }

    @Test
    public void givenTwoNumbersReturnSum() {
        assertEquals(add("1,2"),3);
    }

    @Test
    public void givenMultipleNumbersReturnSum() {
        assertEquals(add("1,2,3,4,5"),15);
    }

    @Test
    public void givenNewLineDelimiterReturnSum() {
        assertEquals(add("1\n2,3"),6);
    }

    @Test
    public void givenCustomDelimiterReturnSum() {
        assertEquals(add("//;\n1;2"),3);
    }

    @Test
    public void givenNegativeNumberThrowException() {
        try {
            add("-1,2");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }
    }

    @Test
    public void givenMultipleNegativeNumbersThrowException() {
        try {
            add("-1,2,-3");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negatives not allowed: -1,-3");
        }
    }
}

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
        assertEquals(1, add("1"));
    }

    @Test
    public void givenTwoNumbersReturnSum() {
        assertEquals(3,add("1,2"));
    }

    @Test
    public void givenMultipleNumbersReturnSum() {
        assertEquals(15,add("1,2,3,4,5"));
    }

    @Test
    public void givenNewLineDelimiterReturnSum() {
        assertEquals(6, add("1\n2,3"));
    }

    @Test
    public void givenCustomDelimiterReturnSum() {
        assertEquals(3, add("//;\n1;2"));
    }

    @Test
    public void givenNegativeNumberThrowException() {
        try {
            add("-1,2");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: -1", e.getMessage());
        }
    }

    @Test
    public void givenMultipleNegativeNumbersThrowException() {
        try {
            add("-1,2,-3");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: -1,-3", e.getMessage());
        }
    }
}

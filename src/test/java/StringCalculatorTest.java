import org.junit.jupiter.api.Test;

import static org.example.StringCalculator.add;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void givenAsteriskCustomDelimiterReturnProduct() {
        assertEquals(2, add("//*\n1*2"));
    }

    @Test
    public void givenNegativeNumberThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            add("-1,2");
        });
        String exceptionMessage = exception.getMessage();
        assertEquals("Negatives not allowed: -1", exceptionMessage);
    }

    @Test
    public void givenMultipleNegativeNumbersThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            add("-1,2,-3");
        });
        String exceptionMessage = exception.getMessage();
        assertEquals("Negatives not allowed: -1,-3", exceptionMessage);
    }

    // in case of a number as a delimiter throw an illegal argument exception
    @Test
    public void givenNumberAsDelimiterThrowException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            add("//2\n122");
        });
        String exceptionMessage = exception.getMessage();
        assertEquals("Numbers as custom delimiter not allowed: 2", exceptionMessage);
    }

}

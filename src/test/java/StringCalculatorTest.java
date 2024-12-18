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
}

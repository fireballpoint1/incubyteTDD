import org.junit.jupiter.api.Test;

import static org.example.StringCalculator.add;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {
    @Test
    public void givenEmptyStringReturnZero() {


        assertEquals(add(),0);
    }
}

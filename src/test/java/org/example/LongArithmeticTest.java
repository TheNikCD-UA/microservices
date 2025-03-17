package org.example;

import com.google.common.math.LongMath;
import org.junit.jupiter.api.Test;
import java.math.RoundingMode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongArithmeticTest {

    long a = 7800000000L;
    long b = 384400000L;

    @Test
    public void testAddition() {
        long expectedSum = 8184400000L;
        long sum = LongMath.checkedAdd(a, b);
        assertEquals(expectedSum, sum, "Addition result is incorrect");
    }

    @Test
    public void testSubtraction() {
        long expectedDiff = 7415600000L;
        long diff = LongMath.checkedAdd(a, -b);
        assertEquals(expectedDiff, diff, "Subtraction result is incorrect");
    }

    @Test
    public void testMultiplication() {
        long expectedProduct = 2998320000000000000L;
        long product = LongMath.checkedMultiply(a, b);
        assertEquals(expectedProduct, product, "Multiplication result is incorrect");
    }

    @Test
    public void testDivision() {
        long expectedQuotient = 20L;
        long quotient = LongMath.divide(a, b, RoundingMode.DOWN);
        assertEquals(expectedQuotient, quotient, "Division result is incorrect");
    }

    @Test
    public void testRemainder() {
        long expectedRemainder = 112000000L;
        long remainder = a % b;
        assertEquals(expectedRemainder, remainder, "Remainder result is incorrect");
    }
}

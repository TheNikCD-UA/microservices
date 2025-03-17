package org.example;

import com.google.common.math.LongMath;
import java.math.RoundingMode;

public class LongArithmetic {
    public static void main(String[] args) {
        long a = 7800000000L;
        long b = 384400000L;

        long sum = LongMath.checkedAdd(a, b);
        System.out.println("Addition: " + sum);

        long diff = LongMath.checkedAdd(a, -b);
        System.out.println("Subtraction: " + diff);

        long product = LongMath.checkedMultiply(a, b);
        System.out.println("Multiplication: " + product);

        long quotient = LongMath.divide(a, b, RoundingMode.HALF_DOWN);
        System.out.println("Division: " + quotient);

        long remainder = a % b;
        System.out.println("Remainder: "+ remainder);
    }
}
